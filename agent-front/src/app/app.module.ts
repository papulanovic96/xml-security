import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AccommodationFormComponent } from './accommodation-form/accommodation-form.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { AppRoutingModule } from './app-routing.module'
import { FormsModule } from '@angular/forms';




@NgModule({
  declarations: [
    AppComponent,
    AccommodationFormComponent,
    LoginFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
