import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-header',
  templateUrl: './search-header.component.html',
  styleUrls: ['./search-header.component.css']
})
export class SearchHeaderComponent implements OnInit {

  @Output()
  queryChangedEvent: EventEmitter<string> = new EventEmitter();

  private previousQuery: string;

  ngOnInit() {
    this.previousQuery = '';
  }

  onKeyUp(newQuery: string) {
    if (newQuery !== this.previousQuery) {
      this.previousQuery = newQuery;
      this.queryChangedEvent.emit(newQuery);
    }
  }
}
