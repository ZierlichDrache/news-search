package com.consdata.solejnik.newssearch.dto;

import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Collection;

public class News {

    private String country;

    private String category;

    private Collection<Article> articles = new ArrayList<>();

    private Long totalResults;

    public static Builder builder() {
        return new Builder();
    }

    public String getCountry() {
        return country;
    }

    public String getCategory() {
        return category;
    }

    public Collection<Article> getArticles() {
        return articles;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public static class Builder {

        private Builder() {
        }

        private String country;

        private String category;

        private Collection<Article> articles;

        private Long totalResults;

        public Builder country(@NonNull final String country) {
            this.country = country;
            return this;
        }

        public Builder category(@NonNull final String category) {
            this.category = category;
            return this;
        }

        public Builder articles(@NonNull final Collection<Article> articles) {
            this.articles = articles;
            return this;
        }

        public Builder totalResults(@NonNull final Long totalResults) {
            this.totalResults = totalResults;
            return this;
        }

        public News build() {
            final News news = new News();

            news.country = this.country;
            news.category = this.category;
            news.articles = this.articles;
            news.totalResults = this.totalResults;

            return news;
        }
    }
}
