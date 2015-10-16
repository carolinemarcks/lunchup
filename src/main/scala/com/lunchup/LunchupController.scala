package com.lunchup

import com.lunchup.data.SurveyData
import com.lunchup.init.{DatabaseInit, DatabaseSessionSupport}
import com.lunchup.models.{LunchupDb, Person}
import org.scalatra._
import scalate.ScalateSupport
import org.squeryl.PrimitiveTypeMode._

class LunchupController extends ScalatraServlet
  with SessionSupport
	with DatabaseSessionSupport 
	with ScalateSupport
	with MethodOverride
	with FlashMapSupport {

  get("/") {
    contentType = "text/html"
    ssp("/index.ssp")
  }

  get("/create-db") {
    contentType = "text/html"

    LunchupDb.create
    LunchupDb.persons.insert(SurveyData.getPersons())
    val persons = from(LunchupDb.persons)(select(_)).toList
    LunchupDb.roles.insert(SurveyData.getRoles())
    val roles = from(LunchupDb.roles)(select(_)).toList
    LunchupDb.connections.insert(SurveyData.getConnections(persons.toSet))
    LunchupDb.rolePersons.insert(SurveyData.getRolePersons(persons.toSet, roles.toSet))

    redirect("/")
  }
  get("/recreate-db") {
    contentType = "text/html"
    LunchupDb.drop
    redirect("/create-db")
  }
  get("/allData") {
    contentType = "text/html"
    val persons = from(LunchupDb.persons)(select(_))
    val connections = from(LunchupDb.connections)(select(_))
    val roles = from(LunchupDb.roles)(select(_))
    val rolePersons = from(LunchupDb.rolePersons)(select(_))

    ssp("/allData.ssp",
      "persons" -> persons,
      "connections" -> connections,
      "roles" -> roles,
      "rolePersons" -> rolePersons
    )
  }
  get("/lunchme") {
    contentType = "text/html"

    params.get("name").map { name =>
      try {
        val person = from(LunchupDb.persons)(p => where(p.name === name) select(p)).toList.head
        ssp("/lunchme.ssp",
          "person" -> person
        )
      } catch {
        case e: Throwable => println(e)
          ssp("/fail.ssp",
            "err" -> s"Sorry, we couldn't find $name in our database")
      }
    } getOrElse ssp("/fail.ssp", "err" -> "Please supply a name!")
  }
  get("/mymatch") {
    contentType = "text/html"
    params.get("name") map { name =>
      try {
        val me = from(LunchupDb.persons)(p => where(p.name === name) select(p)).toList.head
        try {
          val myMatch = from(LunchupDb.matchResults, LunchupDb.persons)((matchResult, person) =>
            where(matchResult.personAId === me.id and matchResult.personBId === person.id)
              select (person)
              orderBy (matchResult.time)
          ).toList.reverse.head

          ssp("/myMatch.ssp",
            "me" -> me,
            "myMatch" -> myMatch
          )
        } catch {
          case e: Throwable => println(e)
            ssp("/fail.ssp",
              "err" -> s"Sorry $name, we don't have a match for you right now!")
        }
      } catch {
        case e: Throwable => println(e)
          ssp("/fail.ssp",
            "err" -> s"Sorry, we couldn't find $name in our database")
      }
    } getOrElse ssp("/fail.ssp", "err" -> "Please supply a name!")
  }

  post("/person/:name") {
    val name = params("name")
    println(s"got a person $name")
    contentType = "text/html"
    val person = new Person(0, params("name"))
    println(Person.create(person))
    redirect("/")
  }

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }
  
}
