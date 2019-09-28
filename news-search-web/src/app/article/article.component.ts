import { Component, OnInit, Input } from '@angular/core';
import { Article } from '../shared/dtos';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent {

  @Input()
  article: Article;

  constructor() { }

  openArticle() {
    window.open(this.article.articleUrl);
  }
}
