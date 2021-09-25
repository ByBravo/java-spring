
#FROM openjdk:11-jdk
FROM adoptopenjdk:11.0.10_9-jdk-openj9-0.24.0
EXPOSE 8080 8081
RUN apt-get update && apt-get install -y zip
COPY /target/micro-inventory-1.0.0.jar micro-inventory-1.0.0.jar
RUN zip -d micro-inventory-1.0.0.jar BOOT-INF/classes/application.properties
CMD ["java","-Duser.timezone=UTC", "-jar", "micro-inventory-1.0.0.jar"]