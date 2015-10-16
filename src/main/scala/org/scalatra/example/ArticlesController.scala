package org.scalatra.example

import org.scalatra._
import scalate.ScalateSupport
import org.scalatra.example.data.DatabaseInit
import org.scalatra.example.data.DatabaseSessionSupport
import org.scalatra.example.models.Article
import org.scalatra.example.models.BlogDb
import org.scalatra.example.models.Person
import org.scalatra.example.models.LunchupDb
import org.squeryl.PrimitiveTypeMode._
import java.util.Random
import java.util.Collections

class ArticlesController extends ScalatraServlet 
  with SessionSupport
	with DatabaseSessionSupport 
	with ScalateSupport
	with MethodOverride
	with FlashMapSupport {

  get("/") {
    contentType = "text/html"
    val persons = from(LunchupDb.persons)(select(_))
    val connections = from(LunchupDb.connections)(select(_))
    val teams = from(LunchupDb.teams)(select(_))
    val teamPersons = from(LunchupDb.teamPersons)(select(_))
    val roles = from(LunchupDb.roles)(select(_))
    val rolePersons = from(LunchupDb.rolePersons)(select(_))
    println(persons.toList)

    ssp("/articles/index",
      "persons" -> persons,
      "connections" -> connections,
      "teams" -> teams,
      "teamPersons" -> teamPersons,
      "roles" -> roles,
      "rolePersons" -> rolePersons
    )
  }
  
  get("/create-db") {
    contentType = "text/html"

    BlogDb.create
    LunchupDb.create
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
