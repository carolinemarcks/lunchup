package com.lunchup

import java.io.{InputStream, OutputStream}
import java.net.InetSocketAddress
import de.neuland.jade4j.Jade4J

import com.sun.net.httpserver.{HttpExchange, HttpHandler, HttpServer}


/**
* Borrowed from https://github.com/softwaremill/simple-http-server to get us started
*/
object SimpleHttpServer {

  def main(args: Array[String]) {
    val server = HttpServer.create(new InetSocketAddress(8000), 0)
    server.createContext("/", new RootHandler())
    server.setExecutor(null)

    server.start()

    println("Hit any key to exit...")

    System.in.read()
    server.stop(0)
  }

}

class RootHandler extends HttpHandler {

  def handle(t: HttpExchange) {
    displayPayload(t.getRequestBody)
    sendResponse(t)
  }

  private def displayPayload(body: InputStream): Unit ={
    println()
    println("******************** REQUEST START ********************")
    println()
    copyStream(body, System.out)
    println()
    println("********************* REQUEST END *********************")
    println()
  }

  private def copyStream(in: InputStream, out: OutputStream) {
    Iterator
      .continually(in.read)
      .takeWhile(-1 !=)
      .foreach(out.write)
  }

  private def sendResponse(t: HttpExchange) {
    val model: java.util.Map[String, Object] = new java.util.HashMap[String, Object]();
    val template = Jade4J.getTemplate("index.jade")
    val response = Jade4J.render(template, model)

    t.sendResponseHeaders(200, response.length())
    val os = t.getResponseBody
    os.write(response.getBytes)
    os.close()
  }

}
