import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { News } from './dtos';
import { SearchArticleQuery } from './search-article-query';

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {

  constructor(private http: HttpClient) { }

  searchArticles(searchQuery: SearchArticleQuery): Observable<News> {
    const url = `/news${searchQuery.searchUrl}`
    return this.http.get<News>(url);
  }
}
