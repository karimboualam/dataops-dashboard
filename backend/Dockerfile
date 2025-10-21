# Étape 1 : builder le projet avec Maven
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : image finale légère pour exécuter ton jar
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose le port utilisé par Spring Boot
EXPOSE 8081

# Démarre ton application
ENTRYPOINT ["java","-jar","app.jar"]
