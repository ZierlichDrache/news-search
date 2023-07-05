FROM node:10.16.3-alpine as front-build

COPY ./news-search-web ./news-search-web
WORKDIR /news-search-web
RUN --mount=type=cache,target=/news-search-web.npm \
  npm set cache /news-search-web.npm && \
  npm install
RUN npm run build

FROM maven:3.6.0-jdk-8-alpine as back-build
COPY ./news-search-app ./news-search-app
COPY ./pom.xml .
COPY --from=front-build news-search-app/src/main/resources/static/ news-search-app/src/main/resources/static/
WORKDIR /news-search-app
RUN echo $(ls -la)
RUN mvn clean package

FROM openjdk:8-jre-alpine as deploy
COPY --from=back-build news-search-app/target/*.jar news-search.jar
ENTRYPOINT ["java", "-jar", "news-search.jar"]
EXPOSE 8080
