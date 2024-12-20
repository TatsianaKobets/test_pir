FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/testpir-0.0.1-SNAPSHOT.jar app.jar

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/testpir
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=password

ENTRYPOINT ["java", "-jar", "app.jar"]