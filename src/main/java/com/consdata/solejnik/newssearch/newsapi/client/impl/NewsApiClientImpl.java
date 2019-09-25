package com.consdata.solejnik.newssearch.newsapi.client.impl;

import com.consdata.solejnik.newssearch.dto.Article;
import com.consdata.solejnik.newssearch.mapper.ArticleMapper;
import com.consdata.solejnik.newssearch.newsapi.client.NewsApiClient;
import com.consdata.solejnik.newssearch.newsapi.dto.ExternalNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class NewsApiClientImpl implements NewsApiClient {

    @Value("${externalApiUrl}")
    private String externalApiUrl;

    private RestTemplate restTemplate;

    @Autowired
    public NewsApiClientImpl(@NonNull final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Collection<Article> searchArticles(@NonNull final String queryString) {
        final String url = externalApiUrl + queryString;

        final ExternalNews externalNews = restTemplate.getForObject(url, ExternalNews.class);

        return externalNews
                .getArticles()
                .stream()
                .map(ArticleMapper::map)
                .collect(Collectors.toList());
    }
}
