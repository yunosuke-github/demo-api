FROM maven:3.8.6-eclipse-temurin-11 AS build
WORKDIR /tmp
COPY ./src ./src
COPY ./pom.xml .
RUN mvn package -DskipTests=true

FROM adoptopenjdk/openjdk11:latest
COPY --from=build /tmp/target/demo-0.0.1-SNAPSHOT.jar /app/demo-api.jar
ENTRYPOINT ["java", "-jar", "/app/demo-api.jar"]