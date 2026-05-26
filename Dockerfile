# Stage 1: Build the Spring Boot Application
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copy the pom.xml to download and cache Maven dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and compile the fat JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the Spring Boot Application inside a lightweight JRE
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the compiled JAR from Stage 1
COPY --from=build /app/target/Bajaj-API-Test-1.0.0.jar app.jar

# Expose port 8080 (which is also Render's default HTTP port)
EXPOSE 8080

# Execute the Spring Boot fat JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
