package com.consdata.solejnik.newssearch.util;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public final class QueryParamsBuilder {

    private StringBuilder sb;


    private String country;

    private String category;

    private String query;

    private Long pageSize;

    private Long page;

    public String getCountryPathVariable() {
        return country;
    }

    public String getCategoryPathVariable() {
        return category;
    }

    public QueryParamsBuilder() {
        sb = new StringBuilder();
    }

    public QueryParamsBuilder country(@NonNull final String country) {
        this.country = country;
        return this;
    }

    public QueryParamsBuilder category(@NonNull final String category) {
        this.category = category;
        return this;
    }

    public QueryParamsBuilder query(@Nullable final String query) {
        this.query = query;
        return this;
    }

    public QueryParamsBuilder pageSize(@Nullable final Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public QueryParamsBuilder page(@Nullable final Long page) {
        this.page = page;
        return this;
    }

    public QueryParamsBuilder builder() {
        return new QueryParamsBuilder();
    }

    public String buildQueryString() {

        validateQueryParams();

        buildCountry();

        buildCategory();

        buildQuery();

        buildPageInfo();


        return sb.toString();
    }

    private void validateQueryParams() {
        if ((pageSize != null && page == null) || (pageSize == null && page != null)) {
            throw new RuntimeException();
        }
    }

    private void buildCountry() {
        if (country != null) {
            sb.append("?country=").append(country);
        }
    }

    private void buildCategory() {
        if (sb.length() == 0 && category != null) {
            sb.append("?").append("category=").append(category);
        } else if (sb.length() > 0 && category != null) {
            sb.append("&").append("category=").append(category);
        }
    }

    private void buildQuery() {
        if (sb.length() == 0 && query != null) {
            sb.append("?").append("q=").append(query);
        } else if (sb.length() > 0 && query != null) {
            sb.append("&").append("q=").append(query);
        }
    }

    private void buildPageInfo() {
        if (sb.length() == 0 && pageSize != null) {
            sb.append("?").append("pageSize=").append(pageSize)
                    .append("&").append("page=").append(page);
        } else if (sb.length() > 0 && pageSize != null) {
            sb.append("&").append("pageSize=").append(pageSize)
                    .append("&").append("page=").append(page);
        }
    }
}
