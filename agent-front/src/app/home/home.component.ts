import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth//token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isLoggedIn: boolean;
  isAgent: boolean;

  public logo = 'assets/logo.png'

  navLinks = [
    {path: "accommodations", label: "Accomodations"}
  ]

  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken() != null) { 
      this.isLoggedIn = true;

      if (this.tokenStorage.getAuthorities().includes('ROLE_AGENT'))
        this.isAgent = true;
    }  
  }

  signOut(){
    this.tokenStorage.signOut();
    this.isLoggedIn = false;
  }

}
