FROM openjdk:8-jdk-alpine
ADD /target/x-mens.jar xmens.jar

ENTRYPOINT ["java", "-jar", "xmens.jar"]

EXPOSE 8080
 