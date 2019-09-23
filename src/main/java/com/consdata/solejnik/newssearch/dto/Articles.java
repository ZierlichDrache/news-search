package com.consdata.solejnik.newssearch.dto;

import com.consdata.solejnik.newssearch.externalapi.dto.ExternalArticle;
import com.consdata.solejnik.newssearch.mapper.ArticleMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class Articles {

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

        private ArticleMapper articleMapper;

        public Builder() {
            this.articleMapper = new ArticleMapper();
        }

        private String country;

        private String category;

        private Collection<Article> articles;

        public Builder country(final String country) {
            this.country = country;
            return this;
        }

        public Builder category(final String category) {
            this.category = category;
            return this;
        }

        public Builder articles(final Collection<ExternalArticle> articles) {
            this.articles = articles
                    .stream()
                    .map(article -> articleMapper.map(article)).collect(Collectors.toList());
            return this;
        }

        public Articles build() {
            final Articles articles = new Articles();

            articles.country = this.country;
            articles.category = this.category;
            articles.articles = this.articles;

            return articles;
        }
    }
}
