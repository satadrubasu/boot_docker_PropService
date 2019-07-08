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
RUN chmod 755 -R /usr/local/app

# all subsequent commands of RUN/COPY/ADD will b eexecuted within this dir
WORKDIR /usr/local/app/

VOLUME /tmp

COPY target/propertyservice-0.0.1-SNAPSHOT.jar /usr/local/app/prop_app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/local/app/prop_app.jar"]
