import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { JwtResponse } from './jwt-response';
import { User } from '../model/user.model';
import { Logrq } from '../model/logrq.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = 'http://localhost:8761/login';
  private signupUrl = 'http://localhost:8761/registration';

  constructor(private http: HttpClient) {
  }

  attemptAuth(credentials: Logrq): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  signUp(info: User): Observable<string> {
    return this.http.post<string>(this.signupUrl, info, httpOptions);
  }
}
