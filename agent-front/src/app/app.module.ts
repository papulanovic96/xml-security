import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AccommodationFormComponent } from './accommodation-form/accommodation-form.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { AppRoutingModule } from './app-routing.module'
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { AccommodationsComponent } from './accommodations/accommodations.component';
import { EditAccommodationnComponent } from './edit-accommodationn/edit-accommodationn.component';




@NgModule({
  declarations: [
    AppComponent,
    AccommodationFormComponent,
    LoginFormComponent,
    HomeComponent,
    AccommodationsComponent,
    EditAccommodationnComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],

  schemas:[NO_ERRORS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
