import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDropdownsComponent } from './search-dropdowns.component';

describe('SearchDropdownsComponent', () => {
  let component: SearchDropdownsComponent;
  let fixture: ComponentFixture<SearchDropdownsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchDropdownsComponent ]
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
