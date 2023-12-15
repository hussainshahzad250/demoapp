#FROM openjdk:11.0

#FROM ubuntu:latest
#RUN apt-get update
#RUN apt-get install -y openjdk-11-jdk
#ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
#ENV PATH=${JAVA_HOME}/bin:${PATH}

FROM alpine:latest
RUN apk update && apk add openjdk11
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"

ARG JAR_FILE=target/*.jar
ENV TZ="Asia/Kolkata"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]