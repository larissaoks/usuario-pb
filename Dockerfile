FROM openjdk:17
EXPOSE 8080
WORKDIR /app
COPY target/usuario-0.0.1-SNAPSHOT.jar ./usuario.jar
ENTRYPOINT java -jar ./usuario.jar
