FROM java:8
VOLUME /tmp
ADD bookkeeper-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=heroku","-jar","/app.jar"]