package com.consdata.solejnik.newssearch.mapper;

import com.consdata.solejnik.newssearch.dto.Articles;
import com.consdata.solejnik.newssearch.externalapi.dto.ExternalArticles;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.stream.Collectors;

public class ArticlesMapper {

    private ArticleMapper articleMapper;

    public ArticlesMapper() {
        this.articleMapper = new ArticleMapper();
    }

    public Articles map(@NonNull final ExternalArticles externalArticles,
                        @Nullable final String country,
                        @Nullable final String category) {

        final Articles articles = new Articles();
        articles.setCountry(country);
        articles.setCategory(category);
        articles.setArticles(externalArticles
                .getArticles()
                .stream()
                .map(article -> articleMapper.map(article)).collect(Collectors.toList()));

        return articles;
    }
}
