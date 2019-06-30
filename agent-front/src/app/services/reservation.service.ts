import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reservation } from '../model/reservation.model';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http : HttpClient) { }

  getReservationsByAcc(id : number){

    return this.http.post<Reservation[]>('api/reservations/getReservations', id);

  }
}
