import { Component, Input } from '@angular/core';
import { Article } from '../shared/dtos';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent  {

  @Input()
  articles: Article[] = [];
}
