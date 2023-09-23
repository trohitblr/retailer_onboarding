# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container at /app
COPY target/falcon-0.0.1-SNAPSHOT.jar /app/falcon-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application listens on (adjust this based on your application)
EXPOSE 8080

# Define environment variables (if needed)
# ENV ENV_VARIABLE_NAME=variable_value

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "falcon-0.0.1-SNAPSHOT.jar"]