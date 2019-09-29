import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { SearchHeaderComponent } from './search-header/search-header.component';
import { SearchDropdownsComponent } from './search-dropdowns/search-dropdowns.component';
import { PaginatedFooterComponent, Page } from './paginated-footer/paginated-footer.component';
import { ArticleComponent } from './article/article.component';
import { ArticlesComponent } from './articles/articles.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { ArticlesService } from './shared/articles.service';
import { of } from 'rxjs';
import { News } from './shared/dtos';

describe('AppComponent unit', () => {
  let service: ArticlesService;
  let component: AppComponent;

  let searchArticlesSpy: jasmine.Spy;

  beforeEach(() => {
    service = {searchArticles: (a) => {}} as ArticlesService;
    component = new AppComponent(service);

    searchArticlesSpy = spyOn(service, 'searchArticles').and.returnValue(of({ articles: [] } as News));
  });

  it('should not call service when just onCountryChangedEvent is called', () => {
    
    // given
    component.ngOnInit();

    // when
    component.onCountryChangedEvent('');

    // then
    expect(searchArticlesSpy).not.toHaveBeenCalled();
  });

  it('should not call service when just onCategoryChangedEvent is called', () => {
    
     // given
     component.ngOnInit();

     // when
     component.onCategoryChangedEvent('');
 
     // then
     expect(searchArticlesSpy).not.toHaveBeenCalled();
  });

  it('should not call service when just onQueryChangedEvent is called', () => {
    
    // given
    component.ngOnInit();

    // when
    component.onQueryChangedEvent('');

    // then
    expect(searchArticlesSpy).not.toHaveBeenCalled();
  });

  it('should not call service when just onPageChange is called', () => {
    
    // given
    component.ngOnInit();

    // when
    component.onPageChange({ pageEvent: { pageIndex: 0 } } as Page);

    // then
    expect(searchArticlesSpy).not.toHaveBeenCalled();
  });


  it('should call service once when all needed methods are called', () => {

    // given
    component.ngOnInit();

    // when
    component.onCountryChangedEvent(' ');
    component.onCategoryChangedEvent(' ');
    component.onPageChange({ pageEvent: { pageIndex: 0 }, pageSize: 1 } as Page);

    // then
    expect(searchArticlesSpy).toHaveBeenCalledTimes(1);
  });

  it('should call service twice when all needed methods are called and onQueryChangedEvent', () => {

    // given
    component.ngOnInit();

    // when
    component.onCountryChangedEvent(' ');
    component.onCategoryChangedEvent(' ');
    component.onPageChange({ pageEvent: { pageIndex: 0 }, pageSize: 1 } as Page);
    component.onQueryChangedEvent(' ');

    // then
    expect(searchArticlesSpy).toHaveBeenCalledTimes(2);
  });

});

describe('AppComponent template', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        SearchHeaderComponent,
        SearchDropdownsComponent,
        PaginatedFooterComponent,
        ArticleComponent,
        ArticlesComponent,
      ],
      imports: [HttpClientTestingModule],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });
});
