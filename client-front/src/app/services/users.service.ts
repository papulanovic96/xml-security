import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { User } from '../model/user.model';
import { Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Reservation } from '../model/reservation.model';


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

  public save(user : User) {
    return this.http.post<User>(this.zuurl + "/registration-service/", user);
  }

  public signin(user : User) {
    return this.http.post<User>(this.zuurl + "/login-service/", user);
  }

  public findMyReservations() : Observable<Reservation[]>{
    return this.http.get<Reservation[]>(this.zuurl + "/main-backend/user/reservations");
  }

  private handleException(err: HttpErrorResponse): Observable<never> {
    return throwError(err.message);
  }

}
