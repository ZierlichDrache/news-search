package com.consdata.solejnik.newssearch.mapper;

import com.consdata.solejnik.newssearch.dto.Articles;
import com.consdata.solejnik.newssearch.externalapi.dto.ExternalArticles;
import org.springframework.lang.NonNull;

public class ArticlesMapper {

    private ArticleMapper articleMapper;

    public ArticlesMapper() {
        this.articleMapper = new ArticleMapper();
    }

    public Articles map(@NonNull final ExternalArticles externalArticles,
                        @NonNull final String country,
                        @NonNull final String category) {

        return Articles
                .builder()
                .country(country)
                .category(category)
                .articles(externalArticles.getArticles())
                .build();
    }
}
