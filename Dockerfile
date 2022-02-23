FROM openjdk:8
EXPOSE 8080
ADD target/chalenge-ml-0.0.1-SNAPSHOT.jar chalenge-ml-app.jar
ENTRYPOINT ["java", "-jar","/chalenge-ml-app.jar"]