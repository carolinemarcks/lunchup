package com.lunchup 

import org.scalatra.{ScalatraBase, FutureSupport, ScalatraServlet}

import slick.driver.JdbcDriver.api._
import java.util.UUID

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import org.scalatra._
import scalate.ScalateSupport

import de.neuland.jade4j.{Jade4J, JadeConfiguration} 
import de.neuland.jade4j.template.{TemplateLoader, FileTemplateLoader}

trait SlickRoutes extends ScalatraBase with FutureSupport {

  def db: Database

  get("/coffees") {
    db.run(Tables.findCoffeesWithSuppliers.result) map { xs =>
      println(xs)
        contentType = "text/plain"
        xs map { case (s1, s2) => f"  $s1 supplied by $s2" } mkString "\n"
    }
  }

  get("/persons") {
    db.run(LunchupTables.findPersons.result) map { xs =>
        contentType = "text/plain"
        xs mkString "\n"
    }
  }

  put("/person/:name") {
    Await.result(db.run(LunchupTables.person.filter(p => p.name === params("name")).result), Duration.Inf) headOption match {
      case Some(_) =>
      case None => db.run(LunchupTables.person += (UUID.randomUUID(), params("name")))
    }
  }
  put("/data/:content") {
    params("content").split(",") match {
      case Array(name, role, lunchBuds@_*) => println(s"name: $name, role: $role, lunchbuds $lunchBuds")
      case _ => println("didn't match")
    }
  }


}

class SlickApp(val db: Database) extends ScalatraServlet with FutureSupport with SlickRoutes with ScalateSupport {
  protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global


  db.run(Tables.createDatabase)
  db.run(LunchupTables.createDatabase)

  get("/") {
    contentType="text/html"
    jade("/index.jade", "layout" -> "",
      "pageName" -> "LunchUp",
      "text" -> "Hey There",
      "books"-> List(new Book("asdfa")))  
  }

}
