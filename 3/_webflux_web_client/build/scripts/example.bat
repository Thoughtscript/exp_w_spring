@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  example startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and EXAMPLE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\example.jar;%APP_HOME%\lib\spring-boot-starter-parent-2.7.8.pom;%APP_HOME%\lib\spring-boot-starter-webflux-3.0.2.jar;%APP_HOME%\lib\spring-boot-starter-data-mongodb-reactive-3.0.2.jar;%APP_HOME%\lib\spring-boot-starter-data-redis-reactive-3.0.2.jar;%APP_HOME%\lib\spring-boot-starter-amqp-3.0.2.jar;%APP_HOME%\lib\mongodb-driver-sync-4.8.2.jar;%APP_HOME%\lib\javax.mail-1.5.6.jar;%APP_HOME%\lib\jakarta.mail-api-2.0.1.jar;%APP_HOME%\lib\jakarta.mail-2.0.1.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\spring-boot-starter-json-3.0.2.jar;%APP_HOME%\lib\spring-boot-starter-data-redis-3.0.2.jar;%APP_HOME%\lib\spring-boot-starter-3.0.2.jar;%APP_HOME%\lib\spring-boot-starter-reactor-netty-3.0.2.jar;%APP_HOME%\lib\spring-webflux-6.0.4.jar;%APP_HOME%\lib\spring-web-6.0.4.jar;%APP_HOME%\lib\mongodb-driver-reactivestreams-4.8.2.jar;%APP_HOME%\lib\reactor-netty-http-1.1.2.jar;%APP_HOME%\lib\lettuce-core-6.2.2.RELEASE.jar;%APP_HOME%\lib\reactor-netty-core-1.1.2.jar;%APP_HOME%\lib\reactor-core-3.5.2.jar;%APP_HOME%\lib\spring-data-mongodb-4.0.1.jar;%APP_HOME%\lib\spring-rabbit-3.0.1.jar;%APP_HOME%\lib\spring-messaging-6.0.4.jar;%APP_HOME%\lib\mongodb-driver-core-4.8.2.jar;%APP_HOME%\lib\bson-record-codec-4.8.2.jar;%APP_HOME%\lib\bson-4.8.2.jar;%APP_HOME%\lib\activation-1.1.jar;%APP_HOME%\lib\angus-activation-2.0.0.jar;%APP_HOME%\lib\jakarta.activation-api-2.1.1.jar;%APP_HOME%\lib\spring-boot-autoconfigure-3.0.2.jar;%APP_HOME%\lib\spring-boot-3.0.2.jar;%APP_HOME%\lib\spring-boot-starter-logging-3.0.2.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\spring-data-redis-3.0.1.jar;%APP_HOME%\lib\spring-data-keyvalue-3.0.1.jar;%APP_HOME%\lib\spring-tx-6.0.4.jar;%APP_HOME%\lib\spring-context-support-6.0.4.jar;%APP_HOME%\lib\spring-context-6.0.4.jar;%APP_HOME%\lib\spring-data-commons-3.0.1.jar;%APP_HOME%\lib\spring-aop-6.0.4.jar;%APP_HOME%\lib\spring-oxm-6.0.4.jar;%APP_HOME%\lib\spring-beans-6.0.4.jar;%APP_HOME%\lib\spring-expression-6.0.4.jar;%APP_HOME%\lib\spring-amqp-3.0.1.jar;%APP_HOME%\lib\spring-core-6.0.4.jar;%APP_HOME%\lib\snakeyaml-1.33.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.14.1.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.14.1.jar;%APP_HOME%\lib\jackson-annotations-2.14.1.jar;%APP_HOME%\lib\jackson-core-2.14.1.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.14.1.jar;%APP_HOME%\lib\jackson-databind-2.14.1.jar;%APP_HOME%\lib\micrometer-observation-1.10.3.jar;%APP_HOME%\lib\reactive-streams-1.0.4.jar;%APP_HOME%\lib\amqp-client-5.16.0.jar;%APP_HOME%\lib\logback-classic-1.4.5.jar;%APP_HOME%\lib\log4j-to-slf4j-2.19.0.jar;%APP_HOME%\lib\jul-to-slf4j-2.0.6.jar;%APP_HOME%\lib\slf4j-api-2.0.6.jar;%APP_HOME%\lib\spring-jcl-6.0.4.jar;%APP_HOME%\lib\netty-codec-http2-4.1.86.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.86.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.86.Final.jar;%APP_HOME%\lib\netty-resolver-dns-native-macos-4.1.86.Final-osx-x86_64.jar;%APP_HOME%\lib\netty-resolver-dns-classes-macos-4.1.86.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.86.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.86.Final-linux-x86_64.jar;%APP_HOME%\lib\micrometer-commons-1.10.3.jar;%APP_HOME%\lib\netty-handler-4.1.86.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.86.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.86.Final.jar;%APP_HOME%\lib\netty-codec-4.1.86.Final.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.86.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.86.Final.jar;%APP_HOME%\lib\netty-transport-4.1.86.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.86.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.86.Final.jar;%APP_HOME%\lib\netty-common-4.1.86.Final.jar;%APP_HOME%\lib\spring-retry-2.0.0.jar;%APP_HOME%\lib\logback-core-1.4.5.jar;%APP_HOME%\lib\log4j-api-2.19.0.jar


@rem Execute example
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %EXAMPLE_OPTS%  -classpath "%CLASSPATH%" io.thoughtscript.example.Application %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable EXAMPLE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%EXAMPLE_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
