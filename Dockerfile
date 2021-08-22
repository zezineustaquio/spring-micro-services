FROM openjdk:11 AS jdk
WORKDIR /source
COPY . /source
RUN ./gradlew build

FROM openjdk:11-jre-slim AS jre
WORKDIR /app
COPY --from=jdk /source/build/libs/micro-services-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]