FROM openjdk:17
ADD /application/target/application-*.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]