package com.consdata.solejnik.newssearch.dto;

import java.util.ArrayList;
import java.util.Collection;

public class PaginatedArticles {
    private Collection<Article> articles = new ArrayList<>();

    private Long totalResult;

    public PaginatedArticles(Collection<Article> articles, Long totalResult) {
        this.articles = articles;
        this.totalResult = totalResult;
    }

    public Collection<Article> getArticles() {
        return articles;
    }

    public Long getTotalResult() {
        return totalResult;
    }
}
