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
2023-10-01T11:56:11.544-05:00  INFO 8556 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-10-01T11:56:11.544-05:00  INFO 8556 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-10-01T11:56:11.545-05:00  INFO 8556 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2023-10-01T11:56:11.594-05:00  INFO 8556 --- [nio-8080-exec-1] i.t.s.helpers.ExampleStaticHelper        : testStaticHelper
2023-10-01T11:56:11.595-05:00  INFO 8556 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 58720256 heapMaxSize: 8573157376 heapFreeSize: 45701896
2023-10-01T11:56:11.595-05:00  INFO 8556 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-01T11:56:11.616-05:00  INFO 8556 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
2023-10-01T11:56:16.620-05:00  INFO 8556 --- [nio-8080-exec-1] i.t.s.helpers.ExampleComponentHelper     : testComponentHelper
2023-10-01T11:56:16.620-05:00  INFO 8556 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : heapSize: 58720256 heapMaxSize: 8573157376 heapFreeSize: 45647384
2023-10-01T11:56:16.620-05:00  INFO 8556 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Garbage collecting...
2023-10-01T11:56:16.641-05:00  INFO 8556 --- [nio-8080-exec-1] i.t.springexps.helpers.JvmHeapHelper     : Sleeping for 5s...
```

## Resources and Shoutouts

* https://www.baeldung.com/java-system-gc
* https://stackoverflow.com/questions/2015463/how-to-view-the-current-heap-size-that-an-application-is-using