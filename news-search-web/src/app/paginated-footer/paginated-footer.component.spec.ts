import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginatedFooterComponent } from './paginated-footer.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';

describe('PaginatedFooterComponent unit', () => {
  let component: PaginatedFooterComponent;

  beforeEach(() => {
    component = new PaginatedFooterComponent();
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
    expect(component.onPageChange).toHaveBeenCalled();
  });

  it('should emit pageChangedEvent when onPageChange is called', () => {

    // given
    spyOn(component.pageChangedEvent, 'emit');

    // when
    component.onPageChange({} as PageEvent);

    // then
    expect(component.pageChangedEvent.emit).toHaveBeenCalled();
  });

  it('should page size be six when window.innerWidth is more than 1200', () => {

    // given
    spyOnProperty(window, 'innerWidth').and.returnValue(1300);

    // when
    component.ngOnInit();

    // then
    expect(component.pageSize).toBe(6);
  });

  it('should page size be four when window.innerWidth is between 1200 and 769', () => {

    // given
    spyOnProperty(window, 'innerWidth').and.returnValue(769);

    // when
    component.ngOnInit();

    // then
    expect(component.pageSize).toBe(4);
  });

  it('should page size be 2 when window.innerWidth is less than 769', () => {

    // given
    spyOnProperty(window, 'innerWidth').and.returnValue(768);

    // when
    component.ngOnInit();

    // then
    expect(component.pageSize).toBe(2);
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
