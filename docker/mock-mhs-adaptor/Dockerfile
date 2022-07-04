FROM gradle:7.2.0-jdk11 AS build

COPY --chown=gradle:gradle mhs-mock /home/gradle/mhs-mock

WORKDIR /home/gradle/mhs-mock

RUN gradle classes

FROM build AS package

RUN gradle --build-cache bootJar

FROM adoptopenjdk/openjdk11:jre

EXPOSE 8084

RUN mkdir /app

COPY --from=package /home/gradle/mhs-mock/build/libs/mock-mhs-service.jar /app/mock-mhs-service.jar

USER 65534

ENTRYPOINT ["java", "-jar", "/app/mock-mhs-service.jar"]
