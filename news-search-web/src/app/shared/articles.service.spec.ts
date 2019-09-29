import { TestBed } from '@angular/core/testing';

import { ArticlesService } from './articles.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { SearchArticleQuery } from './search-article-query';
describe('ArticlesService', () => {
  let service: ArticlesService;
  let http: HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.get(ArticlesService);
    http = TestBed.get(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should call properly api when searchArticles is called', () => {
    
    // given
    const url = '/news/a/b?page=1&pageSize=1';
    const searchQuery = new SearchArticleQuery();
    searchQuery.country = 'a';
    searchQuery.category = 'b';
    searchQuery.pageNumber = 1;
    searchQuery.pageSize = 1;
 
    // when
    service.searchArticles(searchQuery).subscribe();
    const req = http.expectOne(url);

    // then
    expect(req.request.url).toBe(url);
    expect(req.request.method).toBe('GET');
  });
});
