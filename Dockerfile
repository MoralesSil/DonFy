FROM openjdk:21
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/donfy-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} donfy.jar
ENTRYPOINT ["java","-jar","/donfy.jar"]