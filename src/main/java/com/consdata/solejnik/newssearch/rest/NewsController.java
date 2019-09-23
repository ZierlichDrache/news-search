package com.consdata.solejnik.newssearch.rest;

import com.consdata.solejnik.newssearch.dto.Articles;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("news")
public class NewsController {

    @Autowired
    private NewsSearchService newsSearchService;

    @GetMapping
    public Articles searchArticles() {
        return newsSearchService.searchArticles();
    }
}
