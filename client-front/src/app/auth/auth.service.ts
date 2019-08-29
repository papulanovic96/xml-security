import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SigninRequest, SigninResponse } from '../model/signin.model';
import { SignupRequest, SignupResponse } from '../model/signup.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private signupUrl = 'http://localhost:8761/client-registration-service';
  private signinUrl = 'http://localhost:8761/login-service';

  constructor(private http: HttpClient) {
  }

  signUp(request: SignupRequest): Observable<SignupResponse> {
    return this.http.post<SignupResponse>(this.signupUrl, request, httpOptions);
  }

  signIn(credentials: SigninRequest): Observable<SigninResponse> {
    return this.http.post<SigninResponse>(this.signinUrl, credentials, httpOptions);
  }

}
