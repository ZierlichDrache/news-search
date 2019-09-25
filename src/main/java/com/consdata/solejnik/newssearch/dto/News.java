package com.consdata.solejnik.newssearch.dto;

import org.springframework.lang.NonNull;

import java.util.Collection;

public class News {

    private String country;

    private String category;

    private Collection<Article> articles;

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

    public static class Builder {

        private Builder() {
        }

        private String country;

        private String category;

        private Collection<Article> articles;

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

        public News build() {
            final News articles = new News();

            articles.country = this.country;
            articles.category = this.category;
            articles.articles = this.articles;

            return articles;
        }
    }
}
