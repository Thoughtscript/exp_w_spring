# YAML Dot Notation Test

Testing whether dot notation can be used without concern in Spring `application.yml` config files.

`String`, `int`, `List`, and `Map`.

## Use

Maven:

```BASH
mvn clean
mvn install
mvn spring-boot:run
```

Gradle:

```BASH
./gradlew clean
./gradlew build
./gradlew run
```

## Findings

Given [this](./src/main/resources/application.yml) config: 

```yaml
test.example.stringOne: stringOne
test.example.string2: string2
test.example.stringList: 1,2,3,4,5
test.example.number: 1
test.example.map.1: 1
test.example.map.2: 2
test.example.another.stringA: stringA
test.example.another.stringB: stringB
test.example.another.stringC: stringC
test.example.another.stringD: stringD
```

Partial dot notation `@Value` injection will throw an `Error` at application initialization:

```java
//...
@ConfigurationProperties(prefix = "test.example")
public class TestConfig {
    //...

    // Expect these to fail
    @Value("${another.stringA}")
    private String stringA;

    @Value("${another}")
    private String stringD;
}
```

Partial dot notation cannot be used outside an `@ConfigurationProperties` annotated `Bean`/`Class` either:
```java
    // The following will fail anywhere
    @Value("${test.example.another}")
    private String stringC;
```

For the rest:

```
2023-12-30T14:58:27.072-06:00  INFO 8980 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-12-30T14:58:27.079-06:00  INFO 8980 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-12-30T14:58:27.079-06:00  INFO 8980 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.5]
2023-12-30T14:58:27.139-06:00  INFO 8980 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-12-30T14:58:27.140-06:00  INFO 8980 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 680 ms
2023-12-30T14:58:27.195-06:00  INFO 8980 --- [           main] i.t.y.prepopulate.ConfigTestRunner       : stringOne
2023-12-30T14:58:27.196-06:00  INFO 8980 --- [           main] i.t.y.prepopulate.ConfigTestRunner       : string2
2023-12-30T14:58:27.196-06:00  INFO 8980 --- [           main] i.t.y.prepopulate.ConfigTestRunner       : [1, 2, 3, 4, 5]
2023-12-30T14:58:27.196-06:00  INFO 8980 --- [           main] i.t.y.prepopulate.ConfigTestRunner       : 1
2023-12-30T14:58:27.196-06:00  INFO 8980 --- [           main] i.t.y.prepopulate.ConfigTestRunner       : {1=1, 2=2}
2023-12-30T14:58:27.196-06:00  INFO 8980 --- [           main] i.t.y.prepopulate.ConfigTestRunner       : stringB
2023-12-30T14:58:27.196-06:00  INFO 8980 --- [           main] i.t.y.prepopulate.ConfigTestRunner       : yamlString
2023-12-30T14:58:27.390-06:00  INFO 8980 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-12-30T14:58:27.397-06:00  INFO 8980 --- [           main] io.thoughtscript.yamldotnotation.App     : Started App in 1.265 seconds (process running for 1.482)
```

For partial dot notation use a `Map` - it's fully supported. One can also use a fully qualified dot path within the `@ConfigurationProperties` annotated `Bean` regardless of the specified `prefix`.

> Note too that valid YAML can be used simultaneously with dot notation in the same `Properties` file and even within the same `@ConfigurationProperties`.

## Resources and Links

- https://www.baeldung.com/configuration-properties-in-spring-boot