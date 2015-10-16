package com.lunchup

import com.lunchup.init.DatabaseInit
import org.scalatra.test.scalatest._
import org.scalatest.{ FunSuite, BeforeAndAfter }
import org.h2.engine.Session

class LunchupControllerTest extends ScalatraSuite with DatabaseInit with FunSuite with BeforeAndAfter {
  addServlet(classOf[LunchupController], "/*")
  
  before {
    configureDb()
  }
  
  after {
    closeDbConnection()
  }
  
  test("simple get") {
    get("/create-db") {
      status should equal (302)
    }

    get("/") {
      status should equal (200)
    }
  }
}

