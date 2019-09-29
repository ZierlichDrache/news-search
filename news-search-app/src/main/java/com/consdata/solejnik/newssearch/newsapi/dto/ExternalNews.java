package com.consdata.solejnik.newssearch.newsapi.dto;

import java.util.ArrayList;
import java.util.Collection;

public class ExternalNews {

    private Collection<ExternalArticle> articles = new ArrayList<>();

    private String status;

    private Long totalResults;

    public Collection<ExternalArticle> getArticles() {
        return articles;
    }

    public void setArticles(Collection<ExternalArticle> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }
}
