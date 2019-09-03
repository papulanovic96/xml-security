import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './auth/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  title = 'Admin page';

  isAdmin: boolean;
  isLoggedIn: boolean;

  constructor(private tokenStorage: TokenStorageService,
              private router: Router) {

  }

  ngOnInit(): void {
    if (this.tokenStorage.getToken() != null) {
      this.isLoggedIn = true;

      if (this.tokenStorage.getAuthorities().includes('ROLE_ADMIN')) {
        this.isAdmin = true;
      }

    }
  }

  signOut() {
    window.localStorage.clear();
    window.location.reload();
    this.router.navigate(['404']);
  }

}


