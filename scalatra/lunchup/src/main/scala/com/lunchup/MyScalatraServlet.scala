package com.lunchup

import org.scalatra._
import scalate.ScalateSupport
import de.neuland.jade4j.{Jade4J, JadeConfiguration} 
import de.neuland.jade4j.template.{TemplateLoader, FileTemplateLoader}

class MyScalatraServlet extends LunchupStack {

  private val templateName = "index.jade"
  private def buildModel: java.util.Map[String,Object] = {
    val model = new java.util.HashMap[String, Object]()
    val books = new java.util.ArrayList[Book]()
    books.add(new Book("asdfa"))

    model.put("pageName", "LunchUp")
    model.put("text", "Hey There")
    model.put("books", books)
    model
  }

  def indexResponse(): String = {
    val model: java.util.Map[String, Object] = buildModel 
    val template = Jade4J.getTemplate(s"templates/$templateName")
    Jade4J.render(template, model)
  }
  get("/") {
    contentType="text/html"
    jade("/index.jade", "layout" -> "",
      "pageName" -> "LunchUp",
      "text" -> "Hey There",
      "books"-> List(new Book("asdfa")))  
  }

}
