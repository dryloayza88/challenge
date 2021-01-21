FROM openjdk:8-jdk-alpine
EXPOSE 8181
RUN mkdir -p /app/
ADD target/challenge-0.0.1-SNAPSHOT.jar /app/challenge-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/challenge-0.0.1-SNAPSHOT.jar"]