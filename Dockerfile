FROM maven:3.8.5-openjdk-17
WORKDIR /app
COPY pom.xml .
RUN mvn clean package
EXPOSE 8081
ARG JAR_FILE=target/register-account-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
MAINTAINER Mkhuseli Tyhobeka
LABEL authors="Mkhuseli"
ENTRYPOINT ["java", "-jar","app.jar"]