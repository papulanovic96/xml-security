import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AccommodationTypeComponent } from './accommodation-type/accommodation-type.component';
import { AdditionalServicesComponent } from './additional-services/additional-services.component';
import { AdditionalServicesModifyComponent } from './additional-services/additional-services-modify/additional-services-modify.component';
import { AccommodationTypeModifyComponent } from './accommodation-type/accommodation-type-modify/accommodation-type-modify.component';
import { AccommodationCategoryComponent } from './accommodation-category/accommodation-category.component';
import { AccommodationCategoryModifyComponent } from './accommodation-category/accommodation-category-modify/accommodation-category-modify.component';
import { EndUserComponent } from './end-user/end-user.component';
import { CommentComponent } from './comment/comment.component';
import { AgentComponent } from './agent/agent.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { SigninComponent } from './auth/signin/signin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AuthGuard } from './auth/guards/auth-guard.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './auth/auth-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    AccommodationTypeComponent,
    AdditionalServicesComponent,
    AdditionalServicesModifyComponent,
    AccommodationTypeModifyComponent,
    AccommodationCategoryComponent,
    AccommodationCategoryModifyComponent,
    EndUserComponent,
    CommentComponent,
    AgentComponent,
    SigninComponent,
    PageNotFoundComponent,
  ],
  imports: [
    AngularFontAwesomeModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule,
    RouterModule.forRoot([
      {path:'accommodation-type', component: AccommodationTypeComponent, canActivate: [AuthGuard]},
      {path:'accommodation-type/accommodation-type-modify/:id', component: AccommodationTypeModifyComponent, canActivate: [AuthGuard]},
      {path:'additional-services', component: AdditionalServicesComponent, canActivate: [AuthGuard]},
      {path:'additional-services/additional-services-modify/:id', component: AdditionalServicesModifyComponent, canActivate: [AuthGuard]},
      {path:'accommodation-category', component: AccommodationCategoryComponent, canActivate: [AuthGuard]},
      {path:'accommodation-category/accommodation-category-modify/:id', component: AccommodationCategoryModifyComponent, canActivate: [AuthGuard]},
      {path:'end-user-action', component: EndUserComponent, canActivate: [AuthGuard]},
      {path:'comment', component: CommentComponent, canActivate: [AuthGuard]},
      {path:'admin-agent-creation', component: AgentComponent, canActivate: [AuthGuard]},
      {path:'sign-in', component: SigninComponent},
      {path: '**', component: PageNotFoundComponent},
      {path: '404', component: PageNotFoundComponent}
    ])
  ],
  providers: [
    { 
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
