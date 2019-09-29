package com.consdata.solejnik.newssearch.service.impl;

import com.consdata.solejnik.newssearch.dto.PaginatedArticles;
import com.consdata.solejnik.newssearch.newsapi.client.NewsApiClient;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import com.consdata.solejnik.newssearch.util.QueryParamsBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class NewsSearchServiceImplTest {

    @Mock
    private NewsApiClient newsApiClient;

    private NewsSearchService service;

    @Before
    public void setup() {
        service = new NewsSearchServiceImpl(newsApiClient);
        Mockito.when(newsApiClient.searchArticles(anyString())).thenReturn(new PaginatedArticles(Collections.emptyList(), 0L));
    }

    @Test
    public void should_callService_when_searchNewsIsCalled() {

        // given
        final QueryParamsBuilder paramsBuilder = new QueryParamsBuilder();

        // when
        service.searchNews(paramsBuilder);

        // then
        Mockito.verify(newsApiClient, times(1)).searchArticles(anyString());
    }
}
