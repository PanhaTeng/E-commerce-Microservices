FROM openjdk:17
LABEL authors="TengPanhaBill24"
EXPOSE 8761
ADD target/discovery-service-0.0.1-SNAPSHOT.jar discovery-service.jar
ENTRYPOINT ["java", "-jar", "discovery-service.jar"]