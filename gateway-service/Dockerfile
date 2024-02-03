FROM openjdk:17
LABEL authors="TengPanhaBill24"
EXPOSE 8222
ADD target/gateway-service-0.0.1-SNAPSHOT.jar gateway-service.jar
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]