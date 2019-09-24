package com.consdata.solejnik.newssearch.rest;

import com.consdata.solejnik.newssearch.dto.Articles;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import com.consdata.solejnik.newssearch.util.QueryParamsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    private NewsSearchService newsSearchService;

    @GetMapping("/news/{country}/{category}")
    public Articles searchArticles(@PathVariable String country,
                                   @PathVariable String category,
                                   @RequestParam(value = "q", required = false) String query,
                                   @RequestParam(value = "pageSize", required = false) Long pageSize,
                                   @RequestParam(value = "page", required = false) Long page) {
        String queryString = QueryParamsBuilder
                .builder()
                .country(country)
                .category(category)
                .query(query)
                .pageSize(pageSize)
                .page(page)
                .buildQueryString();

        return newsSearchService.searchArticles(queryString, country, category);
    }
}
