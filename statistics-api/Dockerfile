FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
RUN groupadd -r spring && useradd -r -g spring spring
USER spring:spring
WORKDIR /app
COPY --from=build /app/target/statistics-api-*.jar statistics-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "statistics-api.jar"]