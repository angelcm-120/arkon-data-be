FROM openjdk:11
MAINTAINER Angel CM (D)
label "version"="1.0.0-SNAPSHOT"
label "revision"="32fae38"
label "buildtime"="Wed Mar 02 18:09:49 CST 2022"
label "application_name"="mso_metrobus"
USER root

# Set JAVA_HOME
ENV JAVA_HOME=/usr/java/openjdk-11

# Set TimeZone
ENV TZ=America/Mexico_City

# Copies everything over to Docker environment
ARG JAR_FILE=build/libs/mso_metrobus-1.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} //
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Uses port which is used by the actual application
EXPOSE 13000

# Set ENTRYPOINT
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=devlocal", "mso_metrobus-1.0.0-SNAPSHOT.jar", "--server.port=13000"]
