package com.consdata.solejnik.newssearch.rest;

import com.consdata.solejnik.newssearch.dto.News;
import com.consdata.solejnik.newssearch.rest.helper.NewsControllerTestHelper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "externalApiUrl=http://localhost:8089")
public class NewsControllerIntegrationTest {

    /**
     * Mock for external news api
     */
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8089));

    /**
     * Random port for our application
     */
    @LocalServerPort
    private int port;

    /**
     * Rest client for our application
     */
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Response for tests of our application
     */
    private ResponseEntity response;

    @Before
    public void setup() {
        response = null;
    }

    @After
    public void cleanup() {
        wireMockRule.resetAll();
    }

    @Test
    public void should_passBadRequestResponseFromExternalServer() {

        // given
        NewsControllerTestHelper.returnBadRequestFromNewsApi();

        // when
        response = this.restTemplate.getForEntity("http://localhost:" + port + "/news/pl/sports",
                String.class);

        // then
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void should_passUnauthorizedResponseFromExternalServer() {

        // given
        NewsControllerTestHelper.returnUnauthorizedFromNewsApi();

        // when
        response = this.restTemplate.getForEntity("http://localhost:" + port + "/news/pl/sports",
                String.class);

        // then
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    public void should_passTooManyRequestsResponseFromExternalServer() {

        // given
        NewsControllerTestHelper.returnTooManyRequestsFromNewsApi();

        // when
        response = this.restTemplate.getForEntity("http://localhost:" + port + "/news/pl/sports",
                String.class);

        // then
        Assert.assertEquals(HttpStatus.TOO_MANY_REQUESTS, response.getStatusCode());
    }

    @Test
    public void should_mapServerErrorResponseFromExternalServerToServiceUnavailable() {

        // given
        NewsControllerTestHelper.returnServerErrorFromNewsApi();

        // when
        response = this.restTemplate.getForEntity("http://localhost:" + port + "/news/pl/sports",
                String.class);

        // then
        Assert.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, response.getStatusCode());
    }

    @Test
    public void should_returnInternalServerError_when_cannotParseExternalResponseMessage() {

        // given
        NewsControllerTestHelper.returnUnauthorizedWithInvalidMessageFromNewsApi();

        // when
        response = this.restTemplate.getForEntity("http://localhost:" + port + "/news/pl/sports",
                String.class);

        // then
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void should_returnBadRequest_when_pageQueryparamsAreInvalid() {


        // when
        response = this.restTemplate.getForEntity("http://localhost:" + port + "/news/pl/sports?page=2",
                String.class);

        // then
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void should_returnOkStatusWithContent_when_newsApiReturnContent() {

        // given
        NewsControllerTestHelper.returnOkWithContentFromNewsApi();

        // when
        response = this.restTemplate.getForEntity("http://localhost:" + port + "/news/pl/sports",
                News.class);

        // then
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertTrue(!((News) response.getBody()).getArticles().isEmpty());
    }
}
