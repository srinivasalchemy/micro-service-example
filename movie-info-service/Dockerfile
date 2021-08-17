FROM openjdk:8
#RUN mkdir /app
ADD /target/movie-info-service-0.0.1-SNAPSHOT.jar /movie-info.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","movie-info.jar"]