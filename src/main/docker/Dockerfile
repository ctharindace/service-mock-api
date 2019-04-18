FROM frolvlad/alpine-oraclejre8:slim
VOLUME /tmp
ADD service-mock-api-latest.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]