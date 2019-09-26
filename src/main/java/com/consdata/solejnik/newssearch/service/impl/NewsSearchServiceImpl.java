package com.consdata.solejnik.newssearch.service.impl;

import com.consdata.solejnik.newssearch.dto.Article;
import com.consdata.solejnik.newssearch.dto.News;
import com.consdata.solejnik.newssearch.newsapi.client.NewsApiClient;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import com.consdata.solejnik.newssearch.util.QueryParamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NewsSearchServiceImpl implements NewsSearchService {

    private static final Logger logger = LoggerFactory.getLogger(NewsSearchServiceImpl.class);

    private NewsApiClient newsApiClient;

    @Autowired
    public NewsSearchServiceImpl(@NonNull final NewsApiClient newsApiClient) {
        this.newsApiClient = newsApiClient;
    }

    @Override
    public News searchNews(@NonNull final QueryParamsBuilder paramsBuilder) {
        logger.info("Initializing searching for the news");

        final Collection<Article> articles = newsApiClient.searchArticles(paramsBuilder.buildQueryString());

        News news = News
                .builder()
                .country(paramsBuilder.getCountryPathVariable())
                .category(paramsBuilder.getCategoryPathVariable())
                .articles(articles)
                .build();

        logger.info("Completed searching for the articles");

        return news;
    }
}
