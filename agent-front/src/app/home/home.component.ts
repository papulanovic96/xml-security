import { Component, OnInit } from '@angular/core';
import { AuthentService } from '../services/AuthentService';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

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

  constructor(private authent:AuthentService, private router: Router, private http : HttpClient) { }

  ngOnInit() {
  }

  logOut(){
    this.authent.logOutUser();
  }

}
