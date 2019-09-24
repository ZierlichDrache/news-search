package com.consdata.solejnik.newssearch.service.impl;

import com.consdata.solejnik.newssearch.dto.Articles;
import com.consdata.solejnik.newssearch.externalapi.dto.ExternalArticles;
import com.consdata.solejnik.newssearch.mapper.ArticlesMapper;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsSearchServiceImpl implements NewsSearchService {

    @Value("${externalApiUrl}")
    private String externalApiUrl;

    private RestTemplate restTemplate;

    @Autowired
    public NewsSearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Articles searchArticles(final String queryString,
                                   final String country,
                                   final String category) {
        final String url = externalApiUrl + queryString;

        final ExternalArticles externalArticles = restTemplate.getForObject(url, ExternalArticles.class);

        return new ArticlesMapper().map(externalArticles, country, category);
    }
}
