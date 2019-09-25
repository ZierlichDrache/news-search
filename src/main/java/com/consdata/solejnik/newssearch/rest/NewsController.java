package com.consdata.solejnik.newssearch.rest;

import com.consdata.solejnik.newssearch.dto.News;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import com.consdata.solejnik.newssearch.util.QueryParamsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    private NewsSearchService service;

    @Autowired
    public NewsController(@NonNull final  NewsSearchService service) {
        this.service = service;
    }

    @GetMapping("/news/{country}/{category}")
    public News searchArticles(@PathVariable(value = "country", required = false) String country,
                               @PathVariable(value = "category", required = false) String category,
                               @RequestParam(value = "q", required = false) String query,
                               @RequestParam(value = "pageSize", required = false) Long pageSize,
                               @RequestParam(value = "page", required = false) Long page) {
        final QueryParamsBuilder paramsBuilder = new QueryParamsBuilder()
                .builder()
                .country(country)
                .category(category)
                .query(query)
                .pageSize(pageSize)
                .page(page);

        return service.searchNews(paramsBuilder);
    }
}
