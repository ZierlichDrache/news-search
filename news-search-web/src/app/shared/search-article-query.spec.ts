import { SearchArticleQuery } from "./search-article-query";

describe('SearchArticleQuery', () => {
    let searchArticleQuery: SearchArticleQuery;

    beforeEach(() => {
        searchArticleQuery = new SearchArticleQuery();
    });

    it('should not be valid when just country is set', () => {

        // when
        searchArticleQuery.country = ' ';

        // then
        expect(searchArticleQuery.isValid).toBe(false);
    });

    it('should not be valid when just category is set', () => {

        // when
        searchArticleQuery.category = ' ';

        // then
        expect(searchArticleQuery.isValid).toBe(false);
    });

    it('should not be valid when just pageSize is set', () => {

        // when
        searchArticleQuery.pageSize = 1;

        // then
        expect(searchArticleQuery.isValid).toBe(false);
    });

    it('should not be valid when just pageNumber is set', () => {

        // when
        searchArticleQuery.pageNumber = 1;

        // then
        expect(searchArticleQuery.isValid).toBe(false);
    });

    it('should be valid when country, category, pageSize nad pageNumber are set', () => {

        // when
        searchArticleQuery.country = '1';
        searchArticleQuery.category = '1';
        searchArticleQuery.pageNumber = 1;
        searchArticleQuery.pageSize = 1;

        // then
        expect(searchArticleQuery.isValid).toBe(true);
    });

    it('should properly build searcu url', () => {

        // given
        const searchUrl = '/1/1?page=1&pageSize=1&q=1';
        // when
        searchArticleQuery.country = '1';
        searchArticleQuery.category = '1';
        searchArticleQuery.query = '1';
        searchArticleQuery.pageNumber = 1;
        searchArticleQuery.pageSize = 1;

        // then
        expect(searchArticleQuery.searchUrl).toBe(searchUrl);
    });
});