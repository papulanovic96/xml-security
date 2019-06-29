import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AccommodationTypeComponent } from './accommodation-type/accommodation-type.component';
import { AdditionalServicesComponent } from './additional-services/additional-services.component';
import { AdditionalServicesModifyComponent } from './additional-services/additional-services-modify/additional-services-modify.component';
import { AccommodationTypeModifyComponent } from './accommodation-type/accommodation-type-modify/accommodation-type-modify.component';
import { AccommodationCategoryComponent } from './accommodation-category/accommodation-category.component';
import { AccommodationCategoryModifyComponent } from './accommodation-category/accommodation-category-modify/accommodation-category-modify.component';
import { EndUserComponent } from './end-user/end-user.component';
import { CommentComponent } from './comment/comment.component';
import { AgentComponent } from './agent/agent.component';

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
    AgentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path:'accommodation-type', component: AccommodationTypeComponent},
      {path:'accommodation-type/accommodation-type-modify/:id', component: AccommodationTypeModifyComponent},
      {path:'additional-services', component: AdditionalServicesComponent},
      {path:'additional-services/additional-services-modify/:id', component: AdditionalServicesModifyComponent},
      {path:'accommodation-category', component: AccommodationCategoryComponent},
      {path:'accommodation-category/accommodation-category-modify/:id', component: AccommodationCategoryModifyComponent},
      {path:'end-user-action', component: EndUserComponent},
      {path:'comment', component: CommentComponent},
      {path:'admin-agent-creation', component: AgentComponent}
    ], {useHash: true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
