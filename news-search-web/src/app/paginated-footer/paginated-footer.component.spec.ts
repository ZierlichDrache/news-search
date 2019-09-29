import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginatedFooterComponent } from './paginated-footer.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { LayoutService, Layout } from '../shared/layout.service';
import { PageEvent } from '@angular/material/paginator';

describe('PaginatedFooterComponent unit', () => {
  let service: LayoutService;
  let component: PaginatedFooterComponent;

  beforeEach(() => {
    service = { screenLayout: Layout.Laptop } as LayoutService;
    component = new PaginatedFooterComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call onPageChange when ngOnInit is called', () => {

    // given
    spyOn(component, 'onPageChange');

    // when
    component.ngOnInit();

    // then
    expect(component.onPageChange).toHaveBeenCalled();;
  });

  it('should emit pageChangedEvent when onPageChange is called', () => {

    // given
    spyOn(component.pageChangedEvent, 'emit');

    // when
    component.onPageChange({} as PageEvent);

    // then
    expect(component.pageChangedEvent.emit).toHaveBeenCalled();
  });

  it('should page size be six when screen layout from service is Laptop', () => {

    // then
    expect(component.pageSize).toBe(6);
  });
});

describe('PaginatedFooterComponent template', () => {
  let component: PaginatedFooterComponent;
  let fixture: ComponentFixture<PaginatedFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [PaginatedFooterComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
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
