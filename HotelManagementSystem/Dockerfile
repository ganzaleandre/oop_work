# Dockerfile with project-arg for multiple Java modules

# -------------------------
# Build stage: compile the chosen project with Maven + JDK 17
# -------------------------
    ARG PROJECT=HotelManagementSystem
    FROM maven:3-openjdk-17 AS build
    WORKDIR /workspace
    
    # 1) Copy only the POM of the selected module and fetch dependencies offline
    COPY ${PROJECT}/pom.xml ./pom.xml
    RUN mvn dependency:go-offline
    
    # 2) Copy the source of the selected module and build
    COPY ${PROJECT}/src ./src
    RUN mvn clean package -DskipTests
    
    
    # -------------------------
    # Runtime stage: slim OpenJDK container
    # -------------------------
    FROM openjdk:17-jdk-slim AS runtime
    WORKDIR /app
    
    # Copy the resulting JAR from the build stage
    COPY --from=build /workspace/target/*.jar app.jar
    
    # Default entrypoint
    ENTRYPOINT ["java", "-jar", "app.jar"]
    