import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from '../app/auth/auth-interceptor';
import { AppComponent } from './app.component';
import { AccommodationFormComponent } from './accommodation-form/accommodation-form.component';
import { LoginFormComponent } from './auth/login-form/login-form.component';
import { AppRoutingModule } from './app-routing.module'
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { AccommodationsComponent } from './accommodations/accommodations.component';
import { EditAccommodationnComponent } from './edit-accommodationn/edit-accommodationn.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { InboxComponent } from './inbox/inbox.component';
import { ReservationComponent } from './reservation/reservation.component';

@NgModule({
  declarations: [
    AppComponent,
    AccommodationFormComponent,
    LoginFormComponent,
    HomeComponent,
    AccommodationsComponent,
    EditAccommodationnComponent,
    PageNotFoundComponent,
    InboxComponent,
    ReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AngularFontAwesomeModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  schemas:[NO_ERRORS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
