# Étape 1: Choisir l'image de base (par exemple, une image Java si vous avez une application Spring Boot)
FROM openjdk:17-jdk-slim

# Étape 2: Ajouter le fichier jar de l'application (généralement généré via Maven ou Gradle)
COPY target/project-0.0.1-SNAPSHOT.jar /usr/app/user-service.jar

# Étape 3: Spécifier le répertoire de travail
WORKDIR /usr/app

# Étape 4: Exposer le port sur lequel le service sera disponible
EXPOSE 8081

# Étape 5: Lancer l'application
ENTRYPOINT ["java", "-jar", "user-service.jar"]
