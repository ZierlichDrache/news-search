import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-paginated-footer',
  templateUrl: './paginated-footer.component.html',
  styleUrls: ['./paginated-footer.component.scss']
})
export class PaginatedFooterComponent implements OnInit {

  private _pageLenght: number;
  private _pageSize: number;

  @Input()
  set pageLenght(pageLenght: number) {
      this._pageLenght = pageLenght;
  }

  @Output()
  pageChangedEvent: EventEmitter<Page> = new EventEmitter();

  ngOnInit() {
    this.determinePageSize();
    this.onPageChange({pageIndex: 0} as PageEvent);
  }

  onPageChange(pageEvent: PageEvent) {
    this.pageChangedEvent.emit({ pageEvent, pageSize: this.pageSize });
  }

  get pageLenght(): number {
    return this._pageLenght;
  }

  get pageSize(): number {
    return this._pageSize;
  }

  private determinePageSize() {
    const screenWidth: number = window.innerWidth;
    if (screenWidth > 1200) {
      this._pageSize = 6;
    } else if (screenWidth <= 1200 && screenWidth > 768) {
      this._pageSize = 4;
    } else {
      this._pageSize = 2;
    }
  }
}

export interface Page {
  pageEvent: PageEvent;
  pageSize: number;
}
