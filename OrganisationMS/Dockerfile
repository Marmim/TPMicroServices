FROM openjdk:17-jdk-slim
COPY target/OrganisationMS-0.0.1-SNAPSHOT.jar /usr/app/org-service.jar
WORKDIR /usr/app
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "org-service.jar"]
