import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { LayoutService, Layout } from '../shared/layout.service';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-paginated-footer',
  templateUrl: './paginated-footer.component.html',
  styleUrls: ['./paginated-footer.component.css']
})
export class PaginatedFooterComponent implements OnInit {

  private _pageLenght = 5;

  @Input()
  set pageLenght(pageLenght: number) {
    console.log(pageLenght);
      this._pageLenght = pageLenght;
  }

  get pageLenght(): number {
    return this._pageLenght;
  }

  @Output()
  pageChangedEvent: EventEmitter<Page> = new EventEmitter();

  constructor(private readonly layoutService: LayoutService) { }

  ngOnInit() {
    this.onPageChange({pageIndex: 0} as PageEvent);
  }

  onPageChange(pageEvent: PageEvent) {
    this.pageChangedEvent.emit({ pageEvent, pageSize: this.pageSize });
  }

  get pageSize(): number {
    const layout = this.layoutService.screenLayout;
    switch (layout) {
      case Layout.Laptop: {
        return 6;
      }
      case Layout.Tablet: {
        return 4;
      }
      case Layout.Mobile: {
        return 2;
      }
    }
  }
}

export interface Page {
  pageEvent: PageEvent,
  pageSize: number;
}
