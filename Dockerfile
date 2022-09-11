FROM maven:3.8.6 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package 

FROM openjdk:17

ARG eclipse-temurin:17-jdk-jammy

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","api-languages-0.0.1-SNAPSHOT.jar.jar"]