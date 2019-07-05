FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE

# Follow a best practice to install an application into the /usr/local/ folder
# create a new dir /usr/local/app/
# ./app/logs/
# ./app/config/
# ./app/app.jar
#

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
