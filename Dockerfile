FROM adoptopenjdk/openjdk11:alpine
MAINTAINER cliente-service

COPY target/cliente-service.jar cliente-service.jar

ENTRYPOINT ["java","-jar","/cliente-service.jar"]

EXPOSE 80