package com.acme.Example

import java.net.InetSocketAddress
import com.acme.Example.thriftscala.Hello
import com.acme.Example.thriftscala.Hello.FinagledService
import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import com.twitter.finagle.tracing.DefaultTracer
import com.twitter.util.Future
import org.apache.thrift.protocol.TBinaryProtocol.Factory

object ThriftServer {

  /**
   * The service itself. Simply echos back "hi through Thrift"
   */
  class Respond extends Hello.FutureIface {
    override def hi(): Future[String] = Future.value("hi through Thrift")
  }

  def main(args: Array[String]) {
    val service: FinagledService = new FinagledService(new Respond, new Factory())

    ServerBuilder()
      .bindTo(new InetSocketAddress(8081))
      .codec(ThriftServerFramedCodec())
      .tracer(DefaultTracer)
      .name("thriftserver")
      .build(service)
  }
}