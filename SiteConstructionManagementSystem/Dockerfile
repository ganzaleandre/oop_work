## Multi-stage Dockerfile for a single Java project

# 1) Build stage: compile with Maven + JDK 17
FROM maven:3-openjdk-17 AS build
WORKDIR /app

# Copy everything and build the application (skip tests)
COPY . .
RUN mvn clean package -DskipTests


# 2) Runtime stage: run with a slim JDK image
FROM openjdk:17-jdk-slim AS runtime
WORKDIR /app

# Copy the fat JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Default command
ENTRYPOINT ["java", "-jar", "app.jar"]
