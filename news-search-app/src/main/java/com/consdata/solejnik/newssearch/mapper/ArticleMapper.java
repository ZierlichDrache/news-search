package com.consdata.solejnik.newssearch.mapper;

import com.consdata.solejnik.newssearch.dto.Article;
import com.consdata.solejnik.newssearch.newsapi.dto.ExternalArticle;
import org.springframework.lang.NonNull;

public class ArticleMapper {

    private ArticleMapper() {
    }

    public static Article map(@NonNull final ExternalArticle externalArticle) {

        return Article.builder()
                .author(externalArticle.getAuthor())
                .title(externalArticle.getTitle())
                .description(externalArticle.getDescription())
                .date(externalArticle.getPublishedAt())
                .sourceName(externalArticle.getSource().getName())
                .articleUrl(externalArticle.getUrl())
                .imageUrl(externalArticle.getUrlToImage())
                .build();
    }
}
