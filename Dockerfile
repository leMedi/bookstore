FROM openjdk:8-jdk-alpine
RUN mkdir /bookstore
COPY ./target/*.jar /bookstore/app.jar
ENTRYPOINT ["java", "-jar", "/bookstore/app.jar"]