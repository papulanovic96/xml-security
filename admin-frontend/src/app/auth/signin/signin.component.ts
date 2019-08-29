import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, NgModel } from '@angular/forms';

import { Router, RouterLink } from '@angular/router';

import { SigninRequest } from '../signin.model';
import { AuthService } from 'src/app/auth/auth.service';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  private login: SigninRequest;

  public entry: NgModel;

  public account = 'assets/user.png';

  RouterLink : RouterLink;
  ;
  
  signRequest = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  })

  constructor(private authService: AuthService,
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

  signIn() : void {
    this.login = new SigninRequest()
    this.login.username = this.user.username.value
    this.login.password = this.user.password.value

    console.log(this.login);
    
    this.authService.signIn(this.login).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.grantedAuthorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getAuthorities();
        window.location.reload();
      }, 
      error => {
        alert(error.error.message);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      })

  }

  signOut() {
     this.tokenStorage.signOut();
     window.location.reload();
  }

   loggedIn(): boolean{
    console.log(localStorage.getItem('access_token'))
    return localStorage.getItem('access_token') !==  null;
  }

}
