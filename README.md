# NewsSearch Application

This project is destinated for searchin news based on external api with [newsapi](https://newsapi.org).

## Requirements
To develop/deploy this application required is:
- jdk8  
- node v10.16.3
- npm v6.9.0

## Build and run the app
Set enviornment variable JAVA_HOME
To build this app go to root folder and run in console/terminal
- for windows: mvnw clean install
- for linux: sh mvnw clean install

To run, after build, stay in the root folder run in console/terminal
- for windows: mvnw spring-boot:run -pl news-search-app
- for linux: sh mvnw spring-boot:run -pl news-search-app

Now the application is available under url http://localhost:8080/

## Build and start just frontend
To build the frontend go from root to the news-search-web folder and run in console/terminal
- npm install

To run, after build, stai in the folder and run in console/terminal
- npm start

Now the frontent is available under url http://localhost:4200/

## Swagger-Rest API Doku
The REST Api Documentation is available under:
- as plain json file: http://localhost:8080/v2/api-docs
- as swagger ui: http://localhost:8080/swagger-ui.html

## Docker
To create a docker container build the app (more info under Build and deploy the app) go to the root folder and run in console/terminal
- for linux: sudo docker build -f Dockerfile -t news-search .

To run the container with the news sarch app stay in the root folder and run in the console/terminal
- docker run -p 8080:8080 news-search

Now the application is available under url http://localhost:8080/