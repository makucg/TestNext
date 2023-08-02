FROM amazoncorretto:17-alpine-jdk
LABEL authors="diegomontesnovio"
VOLUME /tmp
ADD target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]