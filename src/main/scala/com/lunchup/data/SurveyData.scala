package com.lunchup.data

import com.lunchup.init.DatabaseSessionSupport
import com.lunchup.models._

object SurveyData {
  val roleAndBuddyContent = List(
"Jake Levine,Dev,Rich Hsieh,Adrian Parsons,Evan Estola,,,,,,",
"Brian Gruber,Dev,Yvette Pasqua,Adam Detrick,,,,,,,",
"Kristen Stewart,Design,Jen Gergen,Jose Rodriguez,Byron Hulcher,Daron Lin,,,,,",
"Chris Austin,Design,Jen Gergen,,,,,,,,",
"Wayne Folkes,Systems,Qing Shou,Brandon Price,Ian Corbett,Qing Shou,,,,,",
"Nicole Maslov,HR,Erin Dertouzos,Ella Creedy-Hall,Caroline Marcks,Nora Lorenzo,,,,,",
"Bryan Velzy,Community,Dana Wolma,Aashish Srinivas,Vlad Burca,Lilith Ben-Or,,,,,",
"Laura Ragone,Dev,Will Howard,Paul Bruneau,Brian Capps,,,,,,",
"Jeff Campbell,Dev,Gavin Maisel,Byron Hulcher,Anne DeCusatis,Brian Gruber,,,,,",
"Marina Tempelsman,Strategy,Brian Lafayette,Emily Swanson,,,,,,,",
"Nicole LaTorre,Community,Jenn Louie,Amy Classen,Troy Cox,,,,,,",
"David Anderson,Community,Andrew Williams,Troy Cox,,,,,,,",
"Emily Swanson,Community,Andrew Williams,Ann Nguyen,Samantha Schwartz,Marina Tempelsman,,,,,",
"Anne DeCusatis,Dev,Jose Rodriguez,Byron Hulcher,Coralie Pachaud,,,,,,",
"Nora Lorenzo,HR,Erin Dertouzos,Nicole Maslov,Ella Creedy-Hall,Michelle Heng,,,,,",
"Caroline Marcks,Dev,Jake Levine,Nicole Maslov,Ella Creedy-Hall,Katie Lahey,,,,,",
"Paul Bruneau,Dev,Will Howard,Brian Capps,Laura Ragone,,,,,,",
"David Jimenez,Community,Dana Wolma,David Anderson,Hakiem Simmons,Ann Nguyen,,,,,",
"Caitlyn Gillikin,Community,Andrew Williams,Katie Lahey,,,,,,,",
"Lydia Kopecky,Community,Andrew Williams,Marc Leone,Nicole Maslov,,,,,,",
"Kelty Niles,Strategy,Brian Lafayette,Alex Godin,Victor Longo,,,,,,,",
"Michelle Heng,HR,Erin Dertouzos,Nicole Maslov,Nora Lorenzo,Erin Dertouzos,,,,,",
"Andrew Williams,Community,Dana Wolma,Scott D'Antuono,Sarah Jean Billeiter,Deirdre Johnson,,,,,",
"Alex Godin,,,,,,,,,,",
"Adam Lippman,Product,Fiona Spruill,Jose Rodriguez,Daron Lin,Mike Spencer,Rich Hsieh,Kristen Stewart,Matt Trush,Michael Curtes,Odile Beniflah",
"Mike Perrotti,Design,,,,,,,,,",
"Hannah Bock,Trust & Safety,Jenn Louie,Amy Classen,Nicole LaTorre,Troy Cox,,,,,",
"Laura Blackett,International,Rachel Lafayette,,,,,,,,",
"Ann Nguyen,Community,Andrew Williams,Emily Swanson,Samantha Schwartz,Ryan Rosa,,,,,",
"Sarah Jean Billeiter,Dev,Gavin Maisel,Scott D'Antuono,Andrew Williams,,,,,,",
"Maki Yamamoto,Community,Andrew Williams,Nan Li,Sak Lee,,,,,,",
"Deirdre Johnson,Community,Dana Wolma,Marina Tempelsman,Andrew Williams,Emily Swanson,,,,,",
"Gavin Maisel,Dev,Will Howard,Scott D'Antuono,Sarah Jean Billeiter,Will Howard,,,,,",
"Doug Tangren,Dev,Brian Gruber,,,,,,,,",
"Coralie Pachaud,International,Odile Beniflah,Romy Roloff,Ben Tumin,,,,,,",
"Matthew Holloman,Biz Ops,Ryan Rosa,,,,,,,,",
"Odile Beniflah,International,Fiona Spruill,Coralie Pachaud,Brian Lafayette,Amy Classen,,,,,",
"Ella Creedy-Hall,Community,Andrew Williams,Caroline Marcks,Nicole Maslov,Katie Lahey,,,,,",
"Katie Lahey,Trust & Safety,Jenn Louie,Juan Leguizamon,Ella Creedy-Hall,David Anderson,,,,,",
"Evan Estola,Dev,Brian Gruber,Adrian Parsons,Aashish Srinivas,,,,,,",
"Erin Rauch-Sasseen,Community,Dana Wolma,Samantha Schwartz,,,,,,,",
"Kara Donaldson,Community,Dana Wolma,Nicole LaTorre,,,,,,,",
"Jacob Roa,Community,Dana Wolma,Bryan Velzy,,,,,,,",
"Sarah Cassidy,Community,Andrew Williams,,,,,,,,",
"Daron Lin,Dev,Chris Lewis,Calvin Hu,Jose Rodriguez,Mike Spencer,,,,,",
"Vlad Burca,Dev,Jake Levine,Aashish Srinivas,Mike Spencer,Bryan Velzy,,,,,,,",
"Adaam Hukins,Dev,Gavin Maisel,Scott D'Antuono,Sarah Jean Billeiter,,,,,,",
"Marc Leone,Trust & Safety,Jenn Louie,Scott D'Antuono,Ella Creedy-Hall,Hannah Bock,,,,,",
"Michael Curtes,Product,Fiona Spruill,Farah Assir,Nick Stamas,Rick Boenigk,,,,,",
"Yvette Pasqua,Dev,Scott Heiferman,Andres Glusman,Fiona Spruill,Scott Heiferman,,,,,",
"Matt Kime,Dev,Sadaf Shahsahebi,Adam Detrick,,,,,,,",
"Romy Roloff,Community,Dana Wolma,Juan Leguizamon,Natalia Marmolejo,Victor Longo,,,,,",
"Sadaf Shahsahebi,Dev,Will Howard,,,,,,,,",
"Adam Detrick,Dev,Ivy Feraco,Brian Gruber,Matt Kime,,,,,,",
"Natalia Marmolejo,Design,Jen Gergen,Romy Roloff,Farah Assir,Nick Stamas,,,,,",
"Andrea Murphy,Community,Dana Wolma,,,,,,,,",
"Jose Rodriguez,Dev,Rich Hsieh,Adam Lippman,Daron Lin,Mike Spencer,,,,,",
"Hakiem Simmons,Finance,Julia Brodatska,Scott D'Antuono,Julia Brodatska,David Jimenez,,,,,",
"Amy Classen,Trust & Safety,Jenn Louie,Marina Tempelsman,Nicole Maslov,Hannah Bock,Odile Beniflah,,,,",
"Anna Armentrout,Dev,Sadaf Shahsahebi,Will Carlough,Ivy Feraco,,,,,,",
"Brian Lafayette,Strategy,Andres Glusman,Alex Godin,Andres Glusman,,,,,,",
"Scott D'Antuono,Dev,Gavin Maisel,Sarah Jean Billeiter,Hakiem Simmons,Andrew Williams,,,,,",
"Victor Longo,International,Odile Beniflah,Romy Roloff,Natalia Marmolejo,Coralie Pachaud,Victoria Karunarathna,,,,",
"Camille Alexander,,Brendan McG,Erin Dertouzos,,,,,,,",
"Pamela Rook,Community,Andrew Williams,Bryan Velzy,Samantha Schwartz,Coralie Pachaud,,,,,"
  )
  val teamContent = List(
"Jake Levine,IPA,",
"Brian Gruber,Data,",
"Kristen Stewart,OrgX,Member Growth",
"Chris Austin,Redesign,",
"Wayne Folkes,,",
"Nicole Maslov,Talent & Culture,",
"Bryan Velzy,Member Engagement -- Superfund,",
"Laura Ragone,OrgX,",
"Jeff Campbell,Member Engagement -- Notifs,",
"Marina Tempelsman,Strategy,",
"Nicole LaTorre,Trust & Safety,",
"David Anderson,Community,",
"Emily Swanson,Community,",
"Anne DeCusatis,IPA,",
"Nora Lorenzo,Biz Ops,",
"Caroline Marcks,Member Engagement -- Notifs,",
"Paul Bruneau,Redesign,iOS",
"David Jimenez,Community,",
"Caitlyn Gillikin,Member Growth,",
"Lydia Kopecky,Community,",
"Kelty Niles,OrgX,Strategy",
"Michelle Heng,Talent & Culture,",
"Andrew Williams,Community,",
"Alex Godin,OrgX,Strategy",
"Adam Lippman,OrgX,",
"Mike Perrotti,OrgX,Redesign",
"Hannah Bock,IPA,Trust & Safety",
"Laura Blackett,IPA,",
"Ann Nguyen,Community,",
"Sarah Jean Billeiter,Member Engagement -- Superfund,",
"Maki Yamamoto,Community,",
"Deirdre Johnson,Community,",
"Gavin Maisel,Member Growth,QA",
"Doug Tangren,Member Growth,",
"Coralie Pachaud,IPA,",
"Matthew Holloman,Biz Ops,",
"Odile Beniflah,IPA,",
"Ella Creedy-Hall,OrgX,",
"Katie Lahey,Trust & Safety,",
"Evan Estola,,",
"Erin Rauch-Sasseen,OrgX,",
"Kara Donaldson,Community,",
"Jacob Roa,Community,",
"Sarah Cassidy,Community,",
"Daron Lin,OrgX,",
"Vlad Burca,Member Engagement -- Notifs,",
"Adaam Hukins,OrgX,",
"Marc Leone,Trust & Safety,",
"Michael Curtes,Redesign,Member Engagement -- Superfund,Member Engagement -- Notifs",
"Yvette Pasqua,,",
"Matt Kime,Member Engagement -- Superfund,",
"Romy Roloff,Community,",
"Sadaf Shahsahebi,OrgX,",
"Adam Detrick,Member Engagement -- Superfund,Design",
"Natalia Marmolejo,Redesign,",
"Andrea Murphy,OrgX,Member Engagement -- Superfund",
"Jose Rodriguez,OrgX,",
"Hakiem Simmons,Biz Ops,",
"Amy Classen,Trust & Safety,",
"Anna Armentrout,Tools,",
"Brian Lafayette,Member Engagement -- Notifs,",
"Scott D'Antuono,Member Engagement -- Notifs,",
"Victor Longo,IPA,",
"Camille Alexander,Biz Ops,",
"Pamela Rook,Member Engagement -- Notifs,Community"
)
  def getNames: Map[String, Int] = {
    val roleAndBuddyNames = roleAndBuddyContent.flatMap { line =>
      line.split(",").toList
    }
    val teamNames = teamContent.flatMap { line =>
      line.split(",").toList
    }
    (roleAndBuddyNames ++ teamNames).groupBy{
      case name => name
    }.mapValues {_.size}
  }
  def getPersons(): Set[Person] = {
    val personNames = roleAndBuddyContent.flatMap { line =>
      line.split(",").toList match {
        case name::Nil => List(name)
        case name:: _ :: moreNames => moreNames ++ List(name)
        case _ => Nil
      }
    } ++ teamContent.flatMap { line =>
      line.split(",").toList.headOption
    }
    val nonNilNames = personNames.toSet.filter(_!="")
    nonNilNames map {name => new Person(0,name)}
  }
  def getRoles(): Set[Role] = {
    val roleNames = roleAndBuddyContent.flatMap { line =>
      line.split(",").toList.drop(1).take(1)
    } ++ teamContent.flatMap { line =>
      line.split(",").toList.drop(1)
    }
    val nonNilNames = roleNames.toSet.filter(_!="")
    nonNilNames map {name => new Role(0,name)}
  }
  def getConnections(persons: Set[Person]): Set[Connection] = {
    val nameToId = persons.map { case p => (p.name, p.id) } toMap

    getNameToNamePairs flatMap {
      case (n1, n2) => nameToId.get(n1).flatMap { l1 =>
        nameToId.get(n2).map { l2 =>
          new Connection(l1,l2)
        }
      }
    }
  }
  def getNameToNamePairs(): Set[(String, String)] = {
    roleAndBuddyContent.flatMap { line =>
      line.split(",").toList match {
        case name::_::matches => matches flatMap {m => List((m,name), (name,m))}
        case _ => Nil
      }
    } toSet
  }
  def getRolePersons(persons: Set[Person], roles: Set[Role]): Set[RolePerson] = {
    val personNameToId = persons.map { case p => (p.name, p.id) } toMap
    val roleNameToId = roles.map { case r => (r.name, r.id) } toMap

    getNameToRolePairs flatMap {
      case (person, role) => personNameToId.get(person).flatMap { personId =>
        roleNameToId.get(role).map { roleId =>
          new RolePerson(personId, roleId)
        }
      }
    }
  }
  def getNameToRolePairs(): Set[(String, String)] = {
    val roles: Set[(String,String)] = roleAndBuddyContent.flatMap { line =>
      line.split(",").toList match {
        case name::role::_ => Some(name, role)
        case _ => None
      }
    }  toSet
    val teams: Set[(String, String)] = teamContent.flatMap { line =>
      line.split(",").toList match {
        case name::teams => teams map {t => (name, t)}
        case _ => Nil
      }
    } toSet

    roles ++ teams
  }
  def getOptInNames(): Set[String] = {
    roleAndBuddyContent.flatMap {_.split(",").toList.headOption} filter(_!="") toSet
  }
}
