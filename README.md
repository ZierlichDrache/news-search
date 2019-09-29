# NewsSearch Application

This project is destinated for searchin news based on external api with [newsapi](https://newsapi.org).

## Requirements
To develop/deploy this application required is:
- jdk8

## Build and deploy
To build this app go to root folder and run in console/terminal
- for windows: mvn clean install
- for linux: sh mvnw clean install

To run, after build, run in console/terminal
- for windows: mvn exec:java
- for linux: sh mvnw exec:java

Now the application is available under url http://localhost:8080/

## Swagger-Rest API Doku
The REST Api Documentation is available under:
- as plain json file: http://localhost:8080/v2/api-docs
- as swagger ui: http://localhost:8080/swagger-ui.html
