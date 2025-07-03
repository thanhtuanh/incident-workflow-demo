# Build lokal: mvn clean package
# Dann nur die fertige JAR kopieren

FROM openjdk:17-jdk-slim
WORKDIR /app

COPY target/incident-workflow-demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
