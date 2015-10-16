package com.lunchup.models

import java.util.Date

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

class MatchRequest(val id: Long, val requesterId: Long, val fulfilled: Boolean) extends ScalatraRecord {
  def this() = this(0,0, false)
}
object MatchRequest {
  def create(matchRequest: MatchRequest): Boolean = {
    inTransaction {
      val result = LunchupDb.matchRequests.insert(matchRequest)
      result.isPersisted
    }
  }
}
class MatchResult(val id: Long, val personAId: Long, val personBId: Long, val goodness: Int) extends ScalatraRecord {
  def this() = this(0, 0, 0, 0)
}
object MatchResult {
  def create(matchResult: MatchResult): Boolean = {
    inTransaction {
      val result = LunchupDb.matchResults.insert(matchResult)
      result.isPersisted
    }
  }
}

object LunchupDb extends Schema {
  val persons = table[Person]("persons")
  val connections = table[Connection]("connections")
  val roles = table[Role]("roles")
  val rolePersons = table[RolePerson]("role_persons")
  val matchRequests = table[MatchRequest]("match_requests")
  val matchResults = table[MatchResult]("match_results")

  on(persons)(p => declare (
    p.id is(autoIncremented),
    p.name is(unique)
    ))
  on(roles)(r => declare(
    r.id is(autoIncremented)
  ))
  on(matchResults)(result => declare(
    result.id is(autoIncremented)
  ))
  on(matchRequests)(request => declare(
    request.id is(autoIncremented)
  ))
}

trait ScalatraRecord extends KeyedEntity[Long] with PersistenceStatus {}
