package com.kaoru

import com.kaoru.finagleservices.{TemperatureDatum, TemperatureService}
import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}

object Server extends App {
  val server = Thrift.server.serveIface("localhost:8080", Server())

  Await.result(server)
}

case class Server() extends TemperatureService.MethodPerEndpoint {
  var count = 0

  override def add(datum: TemperatureDatum): Future[Unit] = {
    println("Received add")
    count += 1
    Future(count)
  }

  /** return the mean temperature */
  override def mean(): Future[Double] = {
    println("Received mean")
    Future(count)
  }
}
