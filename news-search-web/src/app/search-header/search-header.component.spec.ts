import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { SearchHeaderComponent } from './search-header.component'; 
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('SearchHeaderComponent unit', () => {
  let component: SearchHeaderComponent;

  beforeEach(() => {
    component = new SearchHeaderComponent();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should emit queryChangedEvent once when onKeyUp is called twice with the same text', () => {

    // given
    spyOn(component.queryChangedEvent, 'emit');

    // when
    component.onKeyUp('spam');
    component.onKeyUp('spam');

    // then
    expect(component.queryChangedEvent.emit).toHaveBeenCalledTimes(1);
  });
});

describe('SearchHeaderComponent template', () => {
  let component: SearchHeaderComponent;
  let fixture: ComponentFixture<SearchHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchHeaderComponent ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
