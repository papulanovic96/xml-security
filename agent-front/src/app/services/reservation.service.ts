import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reservation, UpdateReservationRequest } from '../model/reservation.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private zuurl: string;

  constructor(private http : HttpClient) { 
    this.zuurl = 'https://localhost:8443/';
  }

  getReservationsByAcc(id : number){
    return this.http.post<Reservation[]>('api/reservations/getReservations', id);
  }

  approve(update : UpdateReservationRequest) : Observable<Reservation[]>{
    return this.http.put<Reservation[]>(this.zuurl + 'agent-backend/reservations/approve', update);
  }

  reject(update : UpdateReservationRequest) : Observable<Reservation[]> {
    return this.http.put<Reservation[]>(this.zuurl + 'agent-backend/reservations/reject', update);
  }

  
}
