import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UsersComponent } from './users/users.component';
import { SignUpComponent } from './users/sign-up/sign-up.component';
import { SignInComponent } from './users/sign-in/sign-in.component';
import { AccommodationComponent} from './accommodation/accommodation.component';
import { AccountComponent } from './users/account/account.component';



const routes: Routes = [
  {
    path:'',
    component: AccommodationComponent
  },
  {
    path:'signup',
    component: SignUpComponent
  },
  {
    path:'signin',
    component: SignInComponent
  },
  {
    path:'accommodation',
    component: AccommodationComponent
  },
  {
    path:'account',
    component: AccountComponent
  },
  {
    path:'users',
    component: UsersComponent
  }

];

export const routing = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
