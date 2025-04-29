FROM maven:3.8.8-openjdk-17 AS build
WORKDIR /app

# copy just this module
COPY pom.xml .
COPY src ./src

# build it
RUN mvn clean package -DskipTests

# runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app

# copy the fat-jar from build stage
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
