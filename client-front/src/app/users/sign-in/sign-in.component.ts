import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, NgModel } from '@angular/forms';

import { Router, RouterLink } from '@angular/router';

import { UsersService } from '../../services/users.service';
import { AuthService } from '../../auth/auth.service';
import { TokenStorageService } from '../../auth/token-storage.service';

import { User } from '../../model/user.model';
import { Jwt } from '../../model/jwt.model';
import { Logrq } from 'src/app/model/logrq.model';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  private loginInfo: Logrq;

  public entry: NgModel;

  public account = 'assets/user.png';
  ;
  
  signRequest = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  })

  private token: Jwt;

  constructor(private usersService: UsersService, 
              private router: Router,
              private authService: AuthService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {


    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
    }
  }

  get user() {
    return this.signRequest.controls; 
  }

  signin() : void {
    this.loginInfo = new Logrq()
    
    this.loginInfo.username = this.user.username.value
    this.loginInfo.password = this.user.password.value

    console.log(this.signRequest);

    
    this.authService.attemptAuth(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getAuthorities();
        this.reloadPage();
    }, 
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      })

    this.usersService.signin(this.loginInfo).subscribe(data =>{
      console.log(data)
    },
    err => {
    });
  }

  logout() {
     localStorage.removeItem('access_token');
  }

   loggedIn(): boolean{
    console.log(localStorage.getItem('access_token'))
    return localStorage.getItem('access_token') !==  null;
  }

  reloadPage() {
    window.location.reload();
  }

}
