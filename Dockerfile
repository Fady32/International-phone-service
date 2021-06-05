FROM openjdk:11-jdk-alpine
MAINTAINER Fady Magdy
COPY target/phone-service.jar docker-phone-service.jar
ENTRYPOINT ["java","-jar","/docker-phone-service.jar"]