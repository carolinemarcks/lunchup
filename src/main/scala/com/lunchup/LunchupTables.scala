package com.lunchup

import org.scalatra.{ScalatraBase, FutureSupport, ScalatraServlet}

import slick.driver.JdbcDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global

import org.scalatra._
import scalate.ScalateSupport
import java.util.UUID


object LunchupTables {

  class Person(tag: Tag) extends Table[(UUID, String)](tag, "PERSON") {
    def id = column[UUID]("PERSON_ID", O.PrimaryKey)
    def name = column[String]("NAME")
    def * = (id, name)
    def idx = index("idx_pname", (name), unique = true)
  }
  def person = TableQuery[Person]

  class Connection(tag: Tag) extends Table[(UUID, UUID)](tag, "CONNECTION") {
    def person_one = column[UUID]("PERSON_ONE")
    def person_two = column[UUID]("PERSON_TWO")
    def * = (person_one, person_two)
  }
  def connection = TableQuery[Connection]

  class Team(tag: Tag) extends Table[(UUID, String)](tag, "TEAM") {
    def id = column[UUID]("TEAM_ID", O.PrimaryKey)
    def name = column[String]("NAME")
    
    def * = (id, name)
  }
  def team = TableQuery[Team]
  
  class TeamPerson(tag: Tag) extends Table[(UUID, UUID)](tag, "TEAM_PERSON") {
    def team_id = column[UUID]("TEAM_ID")
    def person_id = column[UUID]("PERSON_ID")

    def * = (team_id, person_id)
  }
  def teamPerson = TableQuery[TeamPerson]

  class Role(tag: Tag) extends Table[(UUID, String)](tag, "ROLE") {
    def id = column[UUID]("ROLE_ID", O.PrimaryKey)
    def name = column[String]("NAME")
    
    def * = (id, name)
  }
  def role = TableQuery[Role]

  class RolePerson(tag: Tag) extends Table[(UUID, UUID)](tag, "ROLE_PERSON") {
    def role_id = column[UUID]("ROLE_ID")
    def person_id = column[UUID]("PERSON_ID")

    def * = (role_id, person_id)
  }
  def rolePerson = TableQuery[RolePerson]

  val findPersons = {
    for {
      p <- person
    } yield (p.id, p.name)
  }
      

  val createSchemaAction = (person.schema ++ 
                            connection.schema ++
                            team.schema ++
                            teamPerson.schema ++
                            role.schema ++
                            rolePerson.schema).create

  

  val createDatabase = DBIO.seq(createSchemaAction)
}
