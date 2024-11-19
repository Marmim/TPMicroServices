FROM openjdk:17-jdk-slim
COPY target/Gateway-0.0.1-SNAPSHOT.jar /usr/app/gateway-service.jar
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]
