FROM openjdk:8-jdk-alpine as builder
MAINTAINER Michael Hiner "mike@amida.com"
RUN apk update && apk upgrade && apk add git
WORKDIR /app
COPY . /app/
RUN ./gradlew build -x test
FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar ./saraswati-jdbc-sink.jar
EXPOSE 8088
ENV active.profiles=docker
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/saraswati-jdbc-sink.jar"]