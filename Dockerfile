FROM azul/zulu-openjdk-alpine:11

MAINTAINER "Eren Baysal"

ENV APP_NAME=interest-service

ENV JAVA_OPTS="\
  -Xmx128m -Xms64m \
  -agentlib:jdwp=transport=dt_socket,server=y,address=5005,suspend=n"

# Copy the artifact with any version into the container and rename the file
COPY ./target/$APP_NAME-*.jar ./$APP_NAME.jar


# Spring Boot Embedded Tomcat Port: 9000
# Remote debugging port: 5005
EXPOSE 9000 5005

ENTRYPOINT exec java $JAVA_OPTS -jar $APP_NAME.jar
