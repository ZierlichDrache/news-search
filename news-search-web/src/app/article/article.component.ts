import { Component, Input } from '@angular/core';
import { Article } from '../shared/dtos';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent {

  @Input()
  article: Article = {} as Article;

  openArticle() {
    window.open(this.article.articleUrl);
  }
}
