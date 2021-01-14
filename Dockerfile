FROM openjdk:8-jdk-alpine
ADD target/x-mens-0.0.1-SNAPSHOT.jar xmens.jar

ENTRYPOINT ["java", "-jar", "xmens.jar"]

EXPOSE 8080
 