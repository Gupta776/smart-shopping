FROM openjdk:8-jdk-alpine
COPY target/product-service-0.0.1-SNAPSHOT.war product.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true","-jar","/product.jar"]