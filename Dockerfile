# 1) Base image with Java runtime
FROM openjdk:17-jdk-slim

# 2) Set working directory inside container
WORKDIR /app

# 3) Copy Maven pom and source code
COPY pom.xml ./
COPY src ./src

# 4) Build your app (skip tests during image build)
RUN apt-get update \
 && apt-get install -y maven \
 && mvn clean package -DskipTests \
 && rm -rf /root/.m2/repository/*

# 5) Bundle the jar and set default command
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
