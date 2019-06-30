import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { User } from '../model/user.model';
import { Logrq } from '../model/logrq.model'
import { Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Reservation } from '../model/reservation.model';

import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private zuurl: string;

  constructor(private http: HttpClient) {
    this.zuurl = 'http://localhost:8761';
  }

  public getUsers(): Observable<User[]> {
        return this.http.get<User[]>(this.zuurl + "/main-backend/user/findAllEndUsers");
  }

  public save(user : User) : Observable<String> {
    return this.http.post<any>(this.zuurl + "/registration-service/", user);
  }

  public signin(log : Logrq) {
    return this.http.post<{access_token:  string}>(this.zuurl + "/login", log).pipe(tap(
      data => {
        localStorage.setItem('access_token', data.access_token)
        console.log(data)
      }));
  }

  public findMyReservations() : Observable<Reservation[]>{
    return this.http.get<Reservation[]>(this.zuurl + "/main-backend/user/reservations");
  }

  public signout() {
    return this.http.get(this.zuurl + "/main-backend/user/logout");
  }

  private handleException(err: HttpErrorResponse): Observable<never> {
    return throwError(err.message);
  }

}
