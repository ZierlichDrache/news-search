package com.consdata.solejnik.newssearch.service;

import com.consdata.solejnik.newssearch.dto.Articles;

public interface NewsSearchService {

    Articles searchArticles(final String queryString,
                            final String country,
                            final String category);
}
