import { Injectable } from '@angular/core';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Accommodation } from '../model/accommodation.model';
import { Reservation } from '../model/reservation.model';


import { Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private zuurl: string;

  constructor(private http: HttpClient) {
    this.zuurl = 'http://localhost:8761'; 
   }

   public create(reservation: Reservation) : Observable<Reservation> { 
     return this.http.post<Reservation>(this.zuurl + "/main-backend/reservation/create", reservation);
   }

}
