import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth//token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLoggedIn = false;
  roles: string[] = [];

  public logo = 'assets/logo.png'

  navLinks = [
    {path: "accommodations", label: "Accomodations"}
  ]

  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
    }
  }

  signOut(){
    this.tokenStorage.signOut();
    this.isLoggedIn = false;
  }

}
