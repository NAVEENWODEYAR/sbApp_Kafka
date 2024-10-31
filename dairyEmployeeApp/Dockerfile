# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/myapp.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Add a label with the name of the application
LABEL name="DairyEmployee"

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
