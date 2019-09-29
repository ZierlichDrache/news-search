package com.consdata.solejnik.newssearch.util;

import com.consdata.solejnik.newssearch.exception.MissingPageParamsException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class QueryParamsBuilderTest {

    private final static String POLAND = "pl";
    private final static String TECHNOLOGY = "technology";
    private final static String QUERY = "sol";
    private final static Long PAGE_SIZE = 2L;
    private final static Long PAGE = 2L;

    @Test
    public void should_properlyBuildQueryStringWithNoParams() {

        // when
        final String actual = new QueryParamsBuilder().buildQueryString();

        // then
        Assert.assertEquals("", actual);
    }

    @Test
    public void should_properlyBuildQueryStringWithAllParams() {

        // when
        final String actual = new QueryParamsBuilder()
                .country(POLAND)
                .category(TECHNOLOGY)
                .query(QUERY)
                .pageSize(PAGE_SIZE)
                .page(PAGE)
                .buildQueryString();

        // then
        Assert.assertEquals("?country=pl&category=technology&q=sol&pageSize=2&page=2", actual);
    }

    @Test
    public void should_properlyBuildQueryWithCountry() {

        // when
        final String actual = new QueryParamsBuilder()
                .country(POLAND)
                .buildQueryString();

        // then
        Assert.assertEquals("?country=pl", actual);
    }

    @Test
    public void should_properlyBuildQueryWithCategory() {

        // when
        final String actual = new QueryParamsBuilder()
                .category(TECHNOLOGY)
                .buildQueryString();

        // then
        Assert.assertEquals("?category=technology", actual);
    }

    @Test
    public void should_properlyBuildQueryWithQuery() {

        // when
        final String actual = new QueryParamsBuilder()
                .query(QUERY)
                .buildQueryString();

        // then
        Assert.assertEquals("?q=sol", actual);
    }

    @Test
    public void should_properlyBuildQueryWithValidPageInfo() {

        // when
        final String actual = new QueryParamsBuilder()
                .pageSize(PAGE_SIZE)
                .page(PAGE)
                .buildQueryString();

        // then
        Assert.assertEquals("?pageSize=2&page=2", actual);
    }

    @Test(expected = MissingPageParamsException.class)
    public void should_thworException_when_pageSizeIsButNoPage() {

        // when
        new QueryParamsBuilder()
                .pageSize(PAGE_SIZE)
                .buildQueryString();

        // then
        // exception
    }

    @Test(expected = MissingPageParamsException.class)
    public void should_thworException_when_pageIsButNoPageSize() {

        // when
        new QueryParamsBuilder()
                .page(PAGE)
                .buildQueryString();

        // then
        // exception
    }
}
