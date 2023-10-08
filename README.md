# exp_w_spring

[![](https://img.shields.io/badge/Java-18-blue.svg)](https://jdk.java.net/archive/)
[![](https://img.shields.io/badge/Spring%20Boot-3.1.4-green.svg)](https://spring.io/projects/spring-boot)
[![](https://img.shields.io/badge/Gradle-7.5.1-darkslategray.svg)](https://gradle.org/)
[![](https://img.shields.io/badge/Maven-3.8.6-white.svg)](https://maven.apache.org/download.cgi)

Experiments with Java Spring.

## Experiments

1. Resolving some questions around YAML dot notation: `property.fieldname.key: 1` in Java Spring config.
1. Verifying JVM overhead for `@Component`-based helpers and `Static Class` helpers.
   * [Findings](2/_findings/Findings.md)
2. Putting the alleged performance improvements of WebFlux WebClient to the test within a non-blocking app.

## Licensing and Use

All findings and code in here is MIT licensed and demonstrates general techniques, Java knowhow, and findings to common but ornery Java Spring questions.