import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { SignInComponent } from './auth/sign-in/sign-in.component';
import { AccommodationComponent} from './accommodation/accommodation.component';
import { AccountComponent } from './account/account.component';
import { InboxComponent } from './inbox/inbox.component';


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
    path:'inbox',
    component: InboxComponent
  }

];

export const routing = RouterModule.forRoot(routes, {useHash: true});

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
