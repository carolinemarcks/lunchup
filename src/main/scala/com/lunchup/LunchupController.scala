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
    val persons = from(LunchupDb.persons)(select(_))
    val connections = from(LunchupDb.connections)(select(_))
    val roles = from(LunchupDb.roles)(select(_))
    val rolePersons = from(LunchupDb.rolePersons)(select(_))

    ssp("/index.ssp",
      "persons" -> persons,
      "connections" -> connections,
      "roles" -> roles,
      "rolePersons" -> rolePersons
    )
  }
  
  get("/create-db") {
    contentType = "text/html"

    LunchupDb.drop
    LunchupDb.create
    LunchupDb.persons.insert(SurveyData.getPersons())
    val persons = from(LunchupDb.persons)(select(_)).toList
    LunchupDb.roles.insert(SurveyData.getRoles())
    val roles = from(LunchupDb.roles)(select(_)).toList
    LunchupDb.connections.insert(SurveyData.getConnections(persons.toSet))
    LunchupDb.rolePersons.insert(SurveyData.getRolePersons(persons.toSet, roles.toSet))

    redirect("/")
  }

  get("/caroline") {
    contentType="text/html"
      jade("/index.jade", "layout" -> "",
          "pageName" -> "LunchUp",
          "text" -> "Hey There")
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
