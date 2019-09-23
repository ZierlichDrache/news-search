package com.consdata.solejnik.newssearch.service.impl;

import com.consdata.solejnik.newssearch.dto.Articles;
import com.consdata.solejnik.newssearch.externalapi.dto.ExternalArticles;
import com.consdata.solejnik.newssearch.mapper.ArticlesMapper;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsSearchServiceImpl implements NewsSearchService {

    private RestTemplate restTemplate;

    private ArticlesMapper articlesMapper;

    @Value("${externalApiUrl}")
    private String externalApiUrl;

    @Value("${externalApiKey}")
    private String externalApiKey;

    public NewsSearchServiceImpl() {
        this.restTemplate = new RestTemplate();
        this.articlesMapper = new ArticlesMapper();
    }

    @Override
    public Articles searchArticles() {
        final ExternalArticles externalArticles = restTemplate.getForObject(externalApiUrl + "?apiKey={apiKey}&q=a",
                ExternalArticles.class, externalApiKey);

        return articlesMapper.map(externalArticles, "", "");
    }
}
