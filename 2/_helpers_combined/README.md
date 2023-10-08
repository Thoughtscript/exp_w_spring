# exp_w_spring

[![](https://img.shields.io/badge/Java-18-blue.svg)](https://jdk.java.net/archive/)
[![](https://img.shields.io/badge/Spring%20Boot-3.1.4-green.svg)](https://spring.io/projects/spring-boot)
[![](https://img.shields.io/badge/Gradle-7.5.1-darkslategray.svg)](https://gradle.org/)
[![](https://img.shields.io/badge/Maven-3.8.6-white.svg)](https://maven.apache.org/download.cgi)

Experiments with Java Spring.

## Use

Maven:

```bash
mvn clean
mvn install
mvn spring-boot:run
```

Gradle:

```bash
./gradlew clean
./gradlew build
./gradlew run
```

## API Endpoints

* `GET http://localhost:8080/api/example/test` 
  * `SUCCESS`
* `GET http://localhost:8080/api/example/getOne` 
  * `{"name":"example","exampleList":[{"name":"exampleListItemA"},{"name":"exampleListItemB"},{"name":"exampleListItemC"}]}`

## Testing

Comparing helper as a `Component` (`Bean`) versus purely `Static` helpers:

```
2023-10-01T12:28:27.528-05:00  INFO 16004 --- [           main] io.thoughtscript.springexps.App          : No active profile set, falling back to 1 default profile: "default"
2023-10-01T12:28:28.196-05:00  INFO 16004 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-10-01T12:28:28.203-05:00  INFO 16004 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-10-01T12:28:28.203-05:00  INFO 16004 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.13]
2023-10-01T12:28:28.270-05:00  INFO 16004 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-10-01T12:28:28.271-05:00  INFO 16004 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 700 ms
2023-10-01T12:28:28.489-05:00  INFO 16004 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-01T12:28:28.496-05:00  INFO 16004 --- [           main] io.thoughtscript.springexps.App          : Started App in 1.255 seconds (process running for 1.471)
2023-10-01T12:28:32.937-05:00  INFO 16004 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-10-01T12:28:32.937-05:00  INFO 16004 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-10-01T12:28:32.937-05:00  INFO 16004 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
2023-10-01T12:28:32.953-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 71303168 heapMaxSize: 8573157376 heapFreeSize: 55056704
2023-10-01T12:28:32.954-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-01T12:28:32.983-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
2023-10-01T12:28:37.985-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.s.helpers.ExampleStaticHelper        : testStaticHelper
2023-10-01T12:28:37.985-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.s.helpers.ExampleStaticHelper        : Time taken 0
2023-10-01T12:28:37.985-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 58720256 heapMaxSize: 8573157376 heapFreeSize: 45596680
2023-10-01T12:28:37.985-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-01T12:28:38.007-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
2023-10-01T12:28:43.022-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.s.helpers.ExampleComponentHelper     : testComponentHelper
2023-10-01T12:28:43.022-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.s.helpers.ExampleComponentHelper     : Time taken 0
2023-10-01T12:28:43.022-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 58720256 heapMaxSize: 8573157376 heapFreeSize: 45708992
2023-10-01T12:28:43.022-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-01T12:28:43.044-05:00  INFO 16004 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
```

## Resources and Shoutouts

* https://www.baeldung.com/java-system-gc
* https://stackoverflow.com/questions/2015463/how-to-view-the-current-heap-size-that-an-application-is-using