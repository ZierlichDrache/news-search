package com.consdata.solejnik.newssearch.newsapi.client;

import com.consdata.solejnik.newssearch.dto.Article;

import java.util.Collection;

public interface NewsApiClient {

    Collection<Article> searchArticles(final String queryString);
}
