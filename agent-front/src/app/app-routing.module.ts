import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormComponent } from './auth/login-form/login-form.component'
import { AccommodationFormComponent } from './accommodation-form/accommodation-form.component'
import { HomeComponent } from './home/home.component'
import { AccommodationsComponent} from './accommodations/accommodations.component'
import { EditAccommodationnComponent } from './edit-accommodationn/edit-accommodationn.component';

const routes: Routes = [
  {
   path: '', redirectTo: '/home', pathMatch: 'full'
  
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
        path: 'accommodations', component: AccommodationsComponent, children:[

          {
            path: '', redirectTo: 'create', pathMatch: 'full'
          },
          {
            path: 'create', component: AccommodationFormComponent
          },
          {
            path: 'update', component: EditAccommodationnComponent
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