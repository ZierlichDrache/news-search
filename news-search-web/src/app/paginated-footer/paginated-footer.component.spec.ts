import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginatedFooterComponent } from './paginated-footer.component';

describe('PaginatedFooterComponent', () => {
  let component: PaginatedFooterComponent;
  let fixture: ComponentFixture<PaginatedFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginatedFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginatedFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
