FROM azul/zulu-openjdk-alpine:16 AS builder
#RUN apk add --no-cache wget
RUN mkdir /app
COPY ./gradlew /app/
COPY ./gradle /app/gradle
COPY ./src /app/src
COPY ./settings.gradle.kts /app/
COPY ./build.gradle.kts /app/
RUN ls -al /app
WORKDIR /app
RUN ./gradlew build

FROM azul/zulu-openjdk-alpine:16-jre
RUN mkdir /app
WORKDIR /app
COPY --from=builder /app/build/libs/app.jar /app/
ENTRYPOINT ["java","-jar","/app/app.jar"]