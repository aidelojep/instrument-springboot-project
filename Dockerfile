FROM openjdk:16-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} instruments-quotes-app.jar
ENTRYPOINT ["java","-jar","/instruments-quotes-app.jar"]