package com.kaoru

import com.kaoru.finagleservices.{TemperatureDatum, TemperatureService}
import com.twitter.finagle.Thrift
import com.twitter.util.Await

object Client extends App {
  val client: TemperatureService.MethodPerEndpoint =
    Thrift.client.build[TemperatureService.MethodPerEndpoint]("localhost:8080")

  val datum: TemperatureDatum = TemperatureDatum(1, System.currentTimeMillis())

  println("RUNNING CLIENT")

  val inFlight = for {
    _ <- client.add(datum)
    result <- client.mean()
  } yield {
    println(s"result: $result")
  }

  Await.result(inFlight)
}

