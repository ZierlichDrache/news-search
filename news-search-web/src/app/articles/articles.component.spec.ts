import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticlesComponent } from './articles.component';
import { ArticleComponent } from '../article/article.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { Article } from '../shared/dtos';
import { By } from '@angular/platform-browser';

describe('ArticlesComponent template', () => {
  let component: ArticlesComponent;
  let fixture: ComponentFixture<ArticlesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticlesComponent, ArticleComponent ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should generate proper amount of article components based on amount of passed articles', () => {

    // given
    component.articles = [{} as Article, {} as Article];

    // when
    fixture.detectChanges();

    // then
    expect(fixture.debugElement.queryAll(By.css('app-article')).length).toBe(2);
  });
});
