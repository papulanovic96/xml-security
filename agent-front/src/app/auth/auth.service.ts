import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SigninRequest, SigninResponse } from '../model/signin.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private signinUrl = 'http://localhost:8761/login-service';

  constructor(private http: HttpClient) {
  }
  
  signIn(credentials: SigninRequest): Observable<SigninResponse> {
    return this.http.post<SigninResponse>(this.signinUrl, credentials, httpOptions);
  }

}
