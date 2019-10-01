FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY news-search-app/target/*.jar news-search.jar
ENTRYPOINT ["java", "-jar", "news-search.jar"]
