import { Injectable } from '@angular/core';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Accommodation } from '../model/accommodation.model';
import { Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Reservation } from '../model/reservation.model';

@Injectable({
  providedIn: 'root'
})
export class AccommodationService {

  private zuurl: string;

  constructor(private http: HttpClient) {
    this.zuurl = 'http://localhost:8761/';
   }

   public getAccommodations() : Observable<Accommodation[]> {
     return this.http.get<Accommodation[]>(this.zuurl + "main-backend/accommodations");
   }
   
}
