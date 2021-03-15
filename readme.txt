

this creates a spring boot based groovy application
It is a hybrid java/groovy application.

 run gradlew assemble to build this

The entire project can be executed from the build directory
to run it use java -jar build/libs/spring-boot-docker-0.1.0.jar

-The java endpoint will print "hello" for a Java Spring rest controler.
-The groovy endpoint will will take a post request of JSON and pretty print it.  See the command ppJson


curl -X POST -H 'Content-Type: application/json' --data-binary "@$1" http://localhost:8080/print

If you are interested in seeing how this is dockerized go here -> https://github.com/chuckhutchinson2/docker-examples/tree/master/spring-boot



