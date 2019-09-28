import { Component, OnInit } from '@angular/core';
import { LayoutService, Layout } from '../shared/layout.service';

@Component({
  selector: 'app-paginated-footer',
  templateUrl: './paginated-footer.component.html',
  styleUrls: ['./paginated-footer.component.css']
})
export class PaginatedFooterComponent implements OnInit {

  constructor(public readonly layoutService: LayoutService) { }

  ngOnInit() {
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
