# Use an official OpenJDK runtime as a parent image
FROM openjdk:17 AS build
COPY --chown=maven:maven ./home/maven/src
RUN mvn clean build
# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/myapp.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Add a label with the name of the application
LABEL name="DairyApp"

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
