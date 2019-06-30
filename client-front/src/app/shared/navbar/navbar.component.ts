import { Component, OnInit } from '@angular/core';

import { UsersService } from '../../services/users.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public logo = 'assets/logo.png'

  constructor(private userService: UsersService) { }

  ngOnInit() {

  }

  signout() {
    console.log("DOSO")
    this.userService.signout().subscribe( 
      data => {
        console.log(data)
      }, 
      err => {

      }
    )
  }

}
