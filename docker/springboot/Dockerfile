FROM openjdk:11-jre

RUN mkdir -p /app/

ADD goldenblock-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
