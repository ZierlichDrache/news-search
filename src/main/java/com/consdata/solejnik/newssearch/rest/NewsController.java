package com.consdata.solejnik.newssearch.rest;

import com.consdata.solejnik.newssearch.dto.News;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import com.consdata.solejnik.newssearch.util.QueryParamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    private NewsSearchService service;

    @Autowired
    public NewsController(@NonNull final NewsSearchService service) {
        this.service = service;
    }

    @GetMapping("/news/{country}/{category}")
    public News searchArticles(@PathVariable final String country,
                               @PathVariable final String category,
                               @RequestParam(value = "q", required = false) final String query,
                               @RequestParam(value = "pageSize", required = false) final Long pageSize,
                               @RequestParam(value = "page", required = false) final Long page) {
        logger.info("Initializing searching for the articles");

        final QueryParamsBuilder paramsBuilder = new QueryParamsBuilder()
                .country(country)
                .category(category)
                .query(query)
                .pageSize(pageSize)
                .page(page);

        final News news = service.searchNews(paramsBuilder);

        logger.info("Completed searching for the articles");

        return news;
    }
}
