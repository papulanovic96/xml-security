import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthentService } from '../services/AuthentService';

@Injectable({
  providedIn: 'root'
})
export class AuthentGuard implements CanActivate {

  constructor(private authService: AuthentService, private router: Router) { }

  canActivate() {
    if (this.authService.isUserLogged()) {
      this.router.navigate(['/home']);
    }
    return !this.authService.isUserLogged();
  }
}