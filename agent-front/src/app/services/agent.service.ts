import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpErrorResponse, HttpClient } from '@angular/common/http';
import { Reservation } from '../model/reservation.model';

@Injectable({
  providedIn: 'root'
})
export class AgentService {
  
  private zuurl: string;

  constructor(private http: HttpClient) {
    this.zuurl = 'https://localhost:8443/';
  }

  public findMyReservations() : Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.zuurl + "agent-backend/agents/reservations/");
  }

  private handleException(err: HttpErrorResponse): Observable<never> {
    return throwError(err.message);
  }
  
}
