FROM openjdk:17
LABEL authors="TengPanhaBill24"
EXPOSE 8091
ADD target/product-service-0.0.1-SNAPSHOT.jar product-service.jar
ENTRYPOINT ["java", "-jar", "product-service.jar"]