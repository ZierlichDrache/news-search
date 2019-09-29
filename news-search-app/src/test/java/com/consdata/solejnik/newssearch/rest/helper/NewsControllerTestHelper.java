package com.consdata.solejnik.newssearch.rest.helper;

import org.springframework.http.HttpStatus;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class NewsControllerTestHelper {

    private NewsControllerTestHelper() {
    }

    private final static byte[] BODY_MESSAGE = "{\"message\":\"Message\"}".getBytes();

    public static void returnBadRequestFromNewsApi() {
        stubFor(get(urlMatching(".*"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.BAD_REQUEST.value())
                        .withBody(BODY_MESSAGE)));
    }

    public static void returnUnauthorizedFromNewsApi() {
        stubFor(get(urlMatching(".*"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.UNAUTHORIZED.value())
                        .withBody(BODY_MESSAGE)));
    }

    public static void returnTooManyRequestsFromNewsApi() {
        stubFor(get(urlMatching(".*"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.TOO_MANY_REQUESTS.value())
                        .withBody(BODY_MESSAGE)));
    }

    public static void returnServerErrorFromNewsApi() {
        stubFor(get(urlMatching(".*"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .withBody(BODY_MESSAGE)));
    }

    public static void returnUnauthorizedWithInvalidMessageFromNewsApi() {
        stubFor(get(urlMatching(".*"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.UNAUTHORIZED.value())
                        .withBody("")));
    }

    public static void returnOkWithContentFromNewsApi() {
        stubFor(get(urlMatching(".*"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"status\":\"ok\",\"totalResults\":1,\"articles\":[{\"source\":{\"id\":null,\"name\":\"source name\"},\"author\":\"Author\",\"title\":\"some title\",\"description\":\"some description\",\"url\":\"article url\",\"urlToImage\":\"image url\",\"publishedAt\":\"2019-09-26T13:46:00Z\",\"content\":\"some content here\"}]}")));
    }
}
