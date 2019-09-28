import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { News } from './dtos';

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {

  constructor(private http: HttpClient) { }

  searchArticles(): Observable<News> {
 
    return this.http.get<News>('http://localhost:8080/news/pl/sports' );
  }
}
