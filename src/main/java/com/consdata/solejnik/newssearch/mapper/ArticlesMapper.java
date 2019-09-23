package com.consdata.solejnik.newssearch.mapper;

import com.consdata.solejnik.newssearch.dto.Articles;
import com.consdata.solejnik.newssearch.externalapi.dto.ExternalArticles;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class ArticlesMapper {

    private ArticleMapper articleMapper;

    public ArticlesMapper() {
        this.articleMapper = new ArticleMapper();
    }

    public Articles map(@NonNull final ExternalArticles externalArticles,
                        @Nullable final String country,
                        @Nullable final String category) {

        return Articles
                .builder()
                .country(country)
                .category(category)
                .articles(externalArticles.getArticles())
                .build();
    }
}
