package com.consdata.solejnik.newssearch.rest;

import com.consdata.solejnik.newssearch.service.NewsSearchService;
import com.consdata.solejnik.newssearch.util.QueryParamsBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class NewsControllerTest {

    @Mock
    private NewsSearchService service;

    private NewsController newsController;

    @Before
    public void setup() {
        newsController = new NewsController(service);
        Mockito.when(service.searchNews(any(QueryParamsBuilder.class))).thenReturn(null);
    }

    @Test
    public void should_callService_whenSearchArticlesIsCalled() {

        // when
        newsController.searchArticles("", "", "", 1L, 2L);

        // then
        Mockito.verify(service, times(1)).searchNews(any(QueryParamsBuilder.class));
    }
}
