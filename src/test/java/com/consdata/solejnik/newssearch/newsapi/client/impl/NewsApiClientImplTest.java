package com.consdata.solejnik.newssearch.newsapi.client.impl;

import com.consdata.solejnik.newssearch.newsapi.client.NewsApiClient;
import com.consdata.solejnik.newssearch.newsapi.dto.ExternalNews;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class NewsApiClientImplTest {

    @Mock
    private RestTemplate restTemplate;

    private NewsApiClient newsApiClient;

    @Before
    public void setup() {
        newsApiClient = new NewsApiClientImpl(restTemplate);
        final ExternalNews externalNews = new ExternalNews();
        externalNews.setArticles(Collections.emptyList());
        Mockito.when(restTemplate.getForObject(anyString(), any())).thenReturn(externalNews);
    }

    @Test
    public void should_callRestTemplate_when_searchArticlesIsCalled() {

        // given
        final ExternalNews externalNews = new ExternalNews();
        externalNews.setArticles(Collections.emptyList());

        // when
        newsApiClient.searchArticles("");

        // then
        Mockito.verify(restTemplate, times(1)).getForObject(anyString(), any());
    }
}
