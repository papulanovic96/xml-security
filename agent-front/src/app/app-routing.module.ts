import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFormComponent } from './login-form/login-form.component'
import { AccommodationFormComponent } from './accommodation-form/accommodation-form.component'
import { HomeComponent } from './home/home.component'
//import { AuthentGuard } from './guards/AuthentGuard'
const routes: Routes = [
  {
    path: '', redirectTo: '/login', pathMatch: 'full'
  },
  {
    path: 'login', component: LoginFormComponent//, canActivate: [AuthentGuard]
  },
  {
    path: 'addaccommodation', component: AccommodationFormComponent, children: []

  },
  {
    path: 'home', component: HomeComponent, children: []
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }