import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import {TooltipModule} from 'ngx-bootstrap/tooltip';
import {ModalModule} from 'ngx-bootstrap/modal';
import {MatButtonModule} from '@angular/material/button';
import {HttpClientModule} from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import {UsersListComponent} from './users-list/users-list.component';
import {MatCardModule} from '@angular/material/card';
import {MatListModule} from '@angular/material/list';
import {MatSelectModule} from "@angular/material/select";

@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent,
    UsersListComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        NoopAnimationsModule,
        NgbModule,
        MatButtonModule,
        MatTableModule,
        MatCardModule,
        MatListModule,
        MatSelectModule
    ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [BsDropdownModule, TooltipModule, ModalModule]
})

export class AppModule {
}
