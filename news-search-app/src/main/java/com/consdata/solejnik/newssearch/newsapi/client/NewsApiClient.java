package com.consdata.solejnik.newssearch.newsapi.client;

import com.consdata.solejnik.newssearch.dto.Article;
import com.consdata.solejnik.newssearch.dto.PaginatedArticles;

import java.util.Collection;

public interface NewsApiClient {

    PaginatedArticles searchArticles(final String queryString);
}
