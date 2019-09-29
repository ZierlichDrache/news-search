import { Component } from '@angular/core';
import { ArticlesService } from './shared/articles.service';
import { Page } from './paginated-footer/paginated-footer.component';
import { SearchArticleQuery } from './shared/search-article-query';
import { Article } from './shared/dtos';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  pageLength: number;

  private _articles: Article[] = [];
  private searchQuery: SearchArticleQuery;

  constructor(private readonly service: ArticlesService) { }

  ngOnInit() {
    this.searchQuery = new SearchArticleQuery();
  }

  onCountryChangedEvent(country: string) {
    this.searchQuery.country = country;
    this.updateArticles();
  }

  onCategoryChangedEvent(category: string) {
    this.searchQuery.category = category;
    this.updateArticles();
  }

  onQueryChangedEvent(query: string) {
    this.searchQuery.query = query;
    this.updateArticles();
  }

  onPageChange(page: Page) {
    this.searchQuery.pageNumber = page.pageEvent.pageIndex + 1;
    this.searchQuery.pageSize = page.pageSize;
    this.updateArticles();
  }

  private updateArticles() {

    if (this.searchQuery.isValid) {
      this.service.searchArticles(this.searchQuery).subscribe(news => {
        this._articles = news.articles;
        this.pageLength = news.totalResults;
      });
    }
  }

  get articles(): Article[] {
    return this._articles;
  }
}
