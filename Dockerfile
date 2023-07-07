FROM node:10.16.3-alpine as front-build

WORKDIR /front
COPY news-search-web/package*.json .
RUN --mount=type=cache,target=/front.npm \
  npm set cache /front.npm && \
  npm install
COPY news-search-web /front
RUN npm run build

FROM maven:3.6.0-jdk-8-alpine as back-build
WORKDIR /back
COPY ./pom.xml .
COPY news-search-app ./app
COPY --from=front-build news-search-app/src/main/resources/static/ app/src/main/resources/static/
RUN mvn -f app/pom.xml clean package

FROM openjdk:8-jre-alpine as deploy
COPY --from=back-build back/app/target/*.jar news-search.jar
ENTRYPOINT ["java", "-jar", "news-search.jar"]
EXPOSE 8080
