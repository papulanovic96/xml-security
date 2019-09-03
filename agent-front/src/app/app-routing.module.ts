import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormComponent } from './auth/login-form/login-form.component'
import { AccommodationFormComponent } from './accommodation-form/accommodation-form.component'
import { HomeComponent } from './home/home.component'
import { AccommodationsComponent} from './accommodations/accommodations.component'
import { EditAccommodationnComponent } from './edit-accommodationn/edit-accommodationn.component';
import { AuthGuard } from './auth/guards/auth-guard.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {
   path: '', redirectTo: '/home', pathMatch: 'full'
  },
  {
    path: '404', component: PageNotFoundComponent  
  },
  {
    path: 'login', component: LoginFormComponent
  },
  {
    path: 'accommodations', component: AccommodationsComponent, children: []
  },
  {
    path: 'home', component: HomeComponent, children: [

      {
        path: '', redirectTo: 'accommodations', pathMatch: 'full'
      },
      {
        path: 'accommodations', component: AccommodationsComponent, canActivate: [AuthGuard], children:[

          {
            path: '', redirectTo: 'create', canActivate: [AuthGuard], pathMatch: 'full'
          },
          {
            path: 'create', component: AccommodationFormComponent, canActivate: [AuthGuard]
          },
          {
            path: 'update', component: EditAccommodationnComponent, canActivate: [AuthGuard]
          }
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }