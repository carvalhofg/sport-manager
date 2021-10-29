FROM openjdk:11-jre
VOLUME /tmp
ARG JAR_FILE
COPY ./${JAR_FILE} app.jar
ENTRYPOINT java -jar sport-manager.jar