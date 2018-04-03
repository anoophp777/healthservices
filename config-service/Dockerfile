FROM openjdk:8-jre-alpine
COPY ./target/config-service-0.0.1-SNAPSHOT.jar /anoop/apps
WORKDIR /anoop/apps
EXPOSE 8888
CMD ["java", "-jar", "config-service-0.0.1-SNAPSHOT.jar"]