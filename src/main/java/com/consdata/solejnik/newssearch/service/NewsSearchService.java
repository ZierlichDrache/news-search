package com.consdata.solejnik.newssearch.service;

import com.consdata.solejnik.newssearch.dto.News;
import com.consdata.solejnik.newssearch.util.QueryParamsBuilder;

public interface NewsSearchService {

    News searchNews(final QueryParamsBuilder paramsBuilder);
}
