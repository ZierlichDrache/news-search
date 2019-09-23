package com.consdata.solejnik.newssearch.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Article {

    private String author;

    private String title;

    private String description;

    private String date;

    private String sourceName;

    private String articleUrl;

    private String imageUrl;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private DateFormat dateFormat;

        private Builder() {
            this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }

        private String author;

        private String title;

        private String description;

        private String date;

        private String sourceName;

        private String articleUrl;

        private String imageUrl;

        public Builder author(final String author) {
            this.author = author;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Builder date(final Date date) {
            this.date = dateFormat.format(date);
            return this;
        }

        public Builder sourceName(final String sourceName) {

            this.sourceName = sourceName;
            return this;
        }

        public Builder articleUrl(final String articleUrl) {
            this.articleUrl = articleUrl;
            return this;
        }

        public Builder imageUrl(final String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Article build() {
            final Article article = new Article();

            article.author = this.author;
            article.title = this.title;
            article.description = this.description;
            article.date = this.date;
            article.sourceName = this.sourceName;
            article.articleUrl = this.articleUrl;
            article.imageUrl = this.imageUrl;

            return article;
        }
    }
}
