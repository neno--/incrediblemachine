# incrediblemachine

first, lets create a gradle project. use info found here:
https://spring.io/guides/gs/gradle/

determine package naming convention:
http://stackoverflow.com/questions/292169/what-package-naming-convention-do-you-use-for-personal-hobby-projects-in-java

com.github.nenomm.im - this looks ok

find applicable .gitignore file
https://gist.github.com/chrisjenx/6138781

spring version used: 4.3.7.RELEASE

determine default logging system for spring - 
see https://docs.spring.io/spring/docs/4.3.7.RELEASE/spring-framework-reference/htmlsingle/#overview-logging
and https://commons.apache.org/proper/commons-logging/guide.html
by default Jdk14Logger is used. - confirmed by debugging.

configure spring with logback:
http://www.codingpedia.org/ama/how-to-log-in-spring-with-slf4j-and-logback/

gradle dsl reference for my version of gradle:
https://docs.gradle.org/2.8/dsl/

