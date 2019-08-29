import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth//token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  navLinks = [
    {path: "accommodations", label: "Accomodations"},
    {path: "messages", label: "Messages"}
  ]

  constructor(private tokeStorage: TokenStorageService, 
              private router: Router) { }

  ngOnInit() {
  }

  logOut(){
    this.tokeStorage.signOut();
  }

}
