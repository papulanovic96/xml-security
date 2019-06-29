import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { Router, RouterLink } from '@angular/router';

import { UsersService } from '../../services/users.service';
import { User } from '../../model/user.model';
import { Jwt } from '../../model/jwt.model';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  public account = 'assets/user.png';

  public signRequest: FormGroup;
  
  private signed: User

  private token: Jwt;

  constructor(private usersService: UsersService, 
              private router: Router) { }

  ngOnInit() {

    this.signRequest = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    })

  }

  get user() {
    return this.signRequest.controls; 
  }


  signin() : void {
    
    console.log(this.signRequest.controls)

    this.signed = new User();
    this.signed.username = this.user.username.value;
    this.signed.password = this.user.password.value;

    this.usersService.signin(this.signed).subscribe(data =>{
      console.log(data);
    });
  }

}
