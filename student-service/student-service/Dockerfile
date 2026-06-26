# student-service/Dockerfile

# Étape 1 : compiler le projet Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
# -DskipTests = on ne lance pas les tests pendant le build Docker

# Étape 2 : image légère pour exécuter le jar
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]