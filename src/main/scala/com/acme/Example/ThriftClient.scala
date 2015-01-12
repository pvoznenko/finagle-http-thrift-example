package com.acme.Example

import com.acme.Example.thriftscala.Hello
import com.twitter.finagle.Thrift

object ThriftClient {
  def apply() {
    val client = Thrift.newIface[Hello.FutureIface]("localhost:8081")

    client.hi() onSuccess { response =>
      println(">> Received response: " + response)
    }
  }
}