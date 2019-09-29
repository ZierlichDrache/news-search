package com.consdata.solejnik.newssearch.rest;

import com.consdata.solejnik.newssearch.dto.News;
import com.consdata.solejnik.newssearch.service.NewsSearchService;
import com.consdata.solejnik.newssearch.util.QueryParamsBuilder;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "Set of endpoints operations of articles.")
public class NewsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    private NewsSearchService service;

    @Autowired
    public NewsController(@NonNull final NewsSearchService service) {
        this.service = service;
    }

    @GetMapping("/news/{country}/{category}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "Search for articles based of specified params.", code = 200)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Found results", response = News.class),
            @ApiResponse(code = 400, message = "Invalid newsapi query"),
            @ApiResponse(code = 400, message = "Invalid page params"),
            @ApiResponse(code = 401, message = "The newsapi key is invalid"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 429, message = "Too many requests from newsapi"),
            @ApiResponse(code = 500, message = "Parsing newsapi error message error"),
            @ApiResponse(code = 503, message = "Newsapi is unavailable")})
    public News searchArticles(@ApiParam("The language and origin country of an article as two letters. Cannot be empty.")
                               @PathVariable final String country,
                               @ApiParam("The category of an article. Cannot be empty.")
                               @PathVariable final String category,
                               @ApiParam("Text which contains an article. Can be empty.")
                               @RequestParam(value = "q", required = false) final String query,
                               @ApiParam("The page size for paginated search. Can be empty.")
                               @RequestParam(value = "pageSize", required = false) final Long pageSize,
                               @ApiParam("The page number for paginated search. Can be empty.")
                               @RequestParam(value = "page", required = false) final Long page
    ) {
        LOGGER.info("Initializing searching for the articles");

        final QueryParamsBuilder paramsBuilder = new QueryParamsBuilder()
                .country(country)
                .category(category)
                .query(query)
                .pageSize(pageSize)
                .page(page);

        final News news = service.searchNews(paramsBuilder);

        LOGGER.info("Completed searching for the articles");

        return news;
    }
}
