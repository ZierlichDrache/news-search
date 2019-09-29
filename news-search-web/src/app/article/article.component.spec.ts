import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleComponent } from './article.component';
import { CUSTOM_ELEMENTS_SCHEMA, DebugElement } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import { By } from '@angular/platform-browser';
import { Article } from '../shared/dtos';

describe('ArticleComponent unit', () => {
  let component: ArticleComponent;

  beforeEach(() => {
    component = new ArticleComponent();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('call window open when openArticle is called', () => {

    // given
    spyOn(window, 'open');
    component.article = {articleUrl: ''} as Article;

    // when
    component.openArticle()

    // then
    expect(window.open).toHaveBeenCalled();
  });
});

describe('ArticleComponent template', () => {
  let component: ArticleComponent;
  let fixture: ComponentFixture<ArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticleComponent ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
      imports: [MatFormFieldModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  function getReadArticleButton(): DebugElement {
    return fixture.debugElement.query(By.css('button'));
  }

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call openArticle when read article button is clicked', () => {
    
    // given
    spyOn(component, 'openArticle');
    
    // when
    getReadArticleButton().nativeElement.click();

    // then
    expect(component.openArticle).toHaveBeenCalled();
  });

  it('should bind article description', () => {
    
    // given
    const description = 'desc';

    // when
    component.article = {description} as Article;
    fixture.detectChanges();

    // then
    expect(fixture.debugElement.query(By.css('mat-label')).nativeElement.innerHTML).toContain(description);
  });

  it('should bind article author', () => {
    
     // given
     const author = 'author';

     // when
     component.article = {author} as Article;
     fixture.detectChanges();
 
     // then
     expect(fixture.debugElement.query(By.css('.author')).nativeElement.innerHTML).toContain(author);
  });

  it('should show unknown author when it is undefined', () => {
    
    // when
    fixture.detectChanges();

    // then
    expect(fixture.debugElement.query(By.css('.author')).nativeElement.innerHTML).toContain('unknown');

  });

  it('should bind article date', () => {
    
    // given
    const date = 'date';

    // when
    component.article = {date} as Article;
    fixture.detectChanges();

    // then
    expect(fixture.debugElement.query(By.css('.date')).nativeElement.innerHTML).toContain(date);
 });
});
