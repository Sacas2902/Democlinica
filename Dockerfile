FROM openjdk:11
COPY ./target/jvmspbootm3-clinica-0.0.1-SNAPSHOT.jar "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar", "jvmspbootm3-clinica-0.0.1-SNAPSHOT.jar"]