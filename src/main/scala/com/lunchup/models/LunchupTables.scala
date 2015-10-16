package com.lunchup.models

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema
import org.squeryl.annotations.Column
import org.squeryl.Query
import org.squeryl.KeyedEntity
import org.squeryl.PersistenceStatus
import org.squeryl.dsl.CompositeKey2

class Person(val id: Long, val name: String) extends ScalatraRecord {
  def this() = this(0, "no name")
}

object Person {
  def create(person: Person): Boolean = {
    inTransaction {
      val result = LunchupDb.persons.insert(person)
      result.isPersisted
    }
  }
}

class Connection(val pAId: Long, val pBId: Long) extends KeyedEntity[CompositeKey2[Long,Long]] with PersistenceStatus {
  def id = compositeKey(pAId, pBId)
  def this() = this(0, 0)
}

object Connection {
  def create(connection: Connection): Boolean = {
    inTransaction {
      val result = LunchupDb.connections.insert(connection)
      result.isPersisted
    }
  }
}
class Team(val id: Long, val name: String) extends ScalatraRecord {
  def this() = this(0, "no name")
}
object Team {
  def create(team: Team): Boolean = {
    inTransaction {
      val result = LunchupDb.teams.insert(team)
      result.isPersisted
    }
  }
}

class TeamPerson(val personId: Long, val teamId: Long) extends KeyedEntity[CompositeKey2[Long,Long]] with PersistenceStatus {
  def id = compositeKey(personId, teamId);
  def this() = this(0,0)
}
object TeamPerson {
  def create(teamPerson: TeamPerson): Boolean = {
    inTransaction {
      val result = LunchupDb.teamPersons.insert(teamPerson)
      result.isPersisted
    }
  }
}

class Role(val id: Long, val name: String) extends ScalatraRecord {
  def this() = this(0, "no name")
}
object Role {
  def create(role: Role): Boolean = {
    inTransaction {
      val result = LunchupDb.roles.insert(role)
      result.isPersisted
    }
  }
}

class RolePerson(val personId: Long, val roleId: Long) extends KeyedEntity[CompositeKey2[Long, Long]] with PersistenceStatus {
  def id = compositeKey(personId, roleId)
  def this() = this(0,0)
}

object RolePerson {
  def create(rolePerson: RolePerson): Boolean = {
    inTransaction {
      val result = LunchupDb.rolePersons.insert(rolePerson)
      result.isPersisted
    }
  }
}

object LunchupDb extends Schema {
  val persons = table[Person]("persons")
  val connections = table[Connection]("connections")
  val teams = table[Team]("teams")
  val teamPersons = table[TeamPerson]("team_persons")
  val roles = table[Role]("roles")
  val rolePersons = table[RolePerson]("role_persons")

  on(persons)(p => declare (
    p.id is(autoIncremented),
    p.name is(unique)
    ))
  on(teams)(t => declare (
    t.id is(autoIncremented)
  ))
  on(roles)(r => declare(
    r.id is(autoIncremented)
  ))
}

trait ScalatraRecord extends KeyedEntity[Long] with PersistenceStatus {}
