package com.consdata.solejnik.newssearch.service.impl;

import com.consdata.solejnik.newssearch.dto.Article;
import com.consdata.solejnik.newssearch.dto.News;
import com.consdata.solejnik.newssearch.newsapi.client.NewsApiClient;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import com.consdata.solejnik.newssearch.util.QueryParamsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NewsSearchServiceImpl implements NewsSearchService {

    private NewsApiClient newsApiClient;

    @Autowired
    public NewsSearchServiceImpl(@NonNull final  NewsApiClient newsApiClient) {
        this.newsApiClient = newsApiClient;
    }

    @Override
    public News searchNews(@NonNull final QueryParamsBuilder paramsBuilder) {
        final Collection<Article> articles = newsApiClient.searchArticles(paramsBuilder.buildQueryString());

        return News
                .builder()
                .country(paramsBuilder.getCountryPathVariable())
                .category(paramsBuilder.getCategoryPathVariable())
                .articles(articles)
                .build();
    }
}
