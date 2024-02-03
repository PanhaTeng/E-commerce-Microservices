FROM openjdk:17
LABEL authors="TengPanhaBill24"
EXPOSE 8090
ADD target/order-service-0.0.1-SNAPSHOT.jar order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]