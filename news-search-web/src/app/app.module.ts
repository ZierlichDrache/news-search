import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { SearchHeaderComponent } from './search-header/search-header.component';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { SearchDropdownsComponent } from './search-dropdowns/search-dropdowns.component';
import { MatSelectModule } from '@angular/material/select';
import { PaginatedFooterComponent } from './paginated-footer/paginated-footer.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { ArticleComponent } from './article/article.component';
import {MatButtonModule} from '@angular/material/button';
import { ArticlesComponent } from './articles/articles.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchHeaderComponent,
    SearchDropdownsComponent,
    PaginatedFooterComponent,
    ArticleComponent,
    ArticlesComponent,
  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    MatInputModule,
    MatIconModule,
    MatSelectModule,
    MatPaginatorModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
