FROM openjdk:17-jdk-slim
COPY target/DonationMS-0.0.1-SNAPSHOT.jar /usr/app/gateway-service.jar
WORKDIR /usr/app
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]
