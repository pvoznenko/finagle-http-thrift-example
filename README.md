# Finagle HTTP and Thrift Clients \ Servers Example

This is example of how you can write Finagle HTTP / Thrift Servers / Clients.

## Try It!

To try it, you should run HTTP by following command:

```
$ sbt "run-main com.acme.Example.HttpServer"
```

Then you should run Thrift Server:

```
$ sbt "run-main com.acme.Example.ThriftServer"
```

And now we ready to do some test calls using HTTP Client:

```
$ sbt "run-main com.acme.Example.HttpClient"
```

At HTTP Client you should get following output:

```
))) Issuing two requests in parallel:
))) Received result for authorized request: hello world
))) Unauthorized request errored (as desired): com.acme.Example.HttpClient$InvalidRequest
```

Since HTTP Service also sending async request to Thrift Server using Thrift Client, in out put of HTTP Server
you should see following output:

```
>> Received response: hi through Thrift
```