import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-dropdowns',
  templateUrl: './search-dropdowns.component.html',
  styleUrls: ['./search-dropdowns.component.css']
})
export class SearchDropdownsComponent implements OnInit {

  @Output()
  countryChangedEvent: EventEmitter<string> = new EventEmitter();

  @Output()
  categoryChangedEvent: EventEmitter<string> = new EventEmitter();

  private _countries: string[];
  private _categories: string[];

  ngOnInit() {
    this._countries = ['ae', 'ar', 'at', 'au', 'be', 'bg', 'br', 'ca', 'ch', 'cn', 'co', 'cu', 'cz', 'de', 'eg', 'fr', 'gb',
      'gr', 'hk', 'hu', 'id', 'ie', 'il', 'in', 'it', 'jp', 'kr', 'lt', 'lv', 'ma', 'mx', 'my', 'ng', 'nl', 'no', 'nz', 'ph', 'pl',
      'pt', 'ro', 'rs', 'ru', 'sa', 'se', 'sg', 'si', 'sk', 'th', 'tr', 'tw', 'ua', 'us', 've', 'za'];
    this._categories = ['business', 'entertainment', 'general', 'health', 'science', 'sports', 'technology'];

    this.countryChangedEvent.emit('pl');
    this.categoryChangedEvent.emit('technology');
  }

  onCountryChange(country: string) {
    this.countryChangedEvent.emit(country);
  }

  onCategoryChange(category: string) {
    this.categoryChangedEvent.emit(category);
  }

  get countries(): string[] {
    return this._countries;
  }

  get categories(): string[] {
    return this._categories;
  }
}
