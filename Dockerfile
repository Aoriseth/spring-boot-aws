FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY "C:\Projects\Toyota\used-car-docker\build\libs\used-car-docker-0.0.1-SNAPSHOT.jar" app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]