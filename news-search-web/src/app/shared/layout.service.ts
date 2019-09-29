import { Injectable, HostListener } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LayoutService {
  private screenWidth: number = window.innerWidth;

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.screenWidth = event.target.innerWidth;
  }

  get screenLayout(): Layout {
    if (this.screenWidth > 1200) {
      return Layout.Laptop;
    } else if (this.screenWidth <= 1200 && this.screenWidth > 768) {
      return Layout.Tablet
    } else {
      return Layout.Mobile;
    }
  }
}

export enum Layout {
  Laptop,
  Tablet,
  Mobile
}
