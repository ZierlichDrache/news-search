import { Component } from '@angular/core';
import { ArticlesService } from './shared/articles.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private readonly service: ArticlesService){}
  
  ngOnInit() {
    this.service.searchArticles().subscribe(news => {
      console.log(news);
    });
  }
}
