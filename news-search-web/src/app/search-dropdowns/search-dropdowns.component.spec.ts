import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDropdownsComponent } from './search-dropdowns.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('SearchDropdownsComponent unit', () => {
  let component: SearchDropdownsComponent;

  beforeEach(() => {
    component = new SearchDropdownsComponent();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should fulfill properly countries when ngOnInit is called', () => {
      
    // pre check if initial undefined
    expect(component.countries).toBe(undefined);

    // when
    component.ngOnInit();

    // then
    expect(component.countries.length).toBeGreaterThan(0);
  });

  it('should fulfill properly categories when ngOnInit is called', () => {
    
    // pre check if initial undefined
    expect(component.categories).toBe(undefined);

    // when
    component.ngOnInit();

    // then
    expect(component.categories.length).toBeGreaterThan(0);
  });

  it('should emit countryChangedEvent when onCountryChange is called', () => {
    
    spyOn(component.countryChangedEvent,'emit');

    component.onCountryChange('');

    expect(component.countryChangedEvent.emit).toHaveBeenCalled();
  });

  it('should emit categoryChangedEvent when onCategoryChange is called', () => {

    spyOn(component.categoryChangedEvent,'emit');

    component.onCategoryChange('');

    expect(component.categoryChangedEvent.emit).toHaveBeenCalled();
  });
});

describe('SearchDropdownsComponent template', () => {
  let component: SearchDropdownsComponent;
  let fixture: ComponentFixture<SearchDropdownsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SearchDropdownsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDropdownsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
