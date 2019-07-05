FROM openjdk:8-jdk-alpine
MAINTAINER satadru.basu@gmail.com

# Follow a best practice to install an application into the /usr/local/ folder
# create a new dir /usr/local/app/
# ./app/logs/
# ./app/config/
# ./app/app.jar
#
RUN mkdir -p /usr/local/app
RUN mkdir -p /usr/local/app/logs
VOLUME /tmp
ARG JAR_FILE

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
