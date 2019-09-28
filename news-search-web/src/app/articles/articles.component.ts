import { Component, OnInit, Input } from '@angular/core';
import { Article } from '../shared/dtos';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  @Input()
  articles: Article[] = [];
  
  ngOnInit() {
    const  article = {
      author: 'stefan i wicio',
      title: 'Puchar Polski. Lech Poznań zagra w kolejnej rundzie z Resovią Rzeszów. Ta proponuje... samolot - Poznan.Wyborcza.',
      description: 'Nigdy dotd Lech Pozna nie gra z Resovi Rzeszw. Ze StalaRzeszw - owszem, ale z Resovi nie. Teraz bdzie okazja, bo Kolejorz wylosował rzeszowsk druyn w drugiej rundzie Pucharu Polski',
      date: '2019-09-27',
      sourceName:'Wyborcza.pl',
      articleUrl:'http://poznan.wyborcza.pl/poznan/7,36013,25241853,puchar-polski-lech-poznan-zagra-w-kolejnej-rundzie-z-resovia.html',
      imageUrl:'https://bi.im-g.pl/im/3b/06/18/z25191995FBW.jpg'
    } as Article

    this.articles.push(article); 
    this.articles.push(article); 
    this.articles.push(article); 
  }
}
