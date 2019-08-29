import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Agent, CreateAgentRequest } from './agent.model';
import { catchError, map } from 'rxjs/operators';
import { Address } from '../address.model';

@Injectable({
  providedIn: 'root'
})
export class AgentService {

  private zuurl = 'http://localhost:8761/';

  private findAllUrl = this.zuurl + 'main-backend/agents';
  private saveUrl = this.zuurl + 'agent-creation-service';
  private findAllAddressesUrl = this.zuurl + 'main-backend/addresses';
  private saveItUrl = this.zuurl + 'main-backend/addresses';

  constructor(private http: HttpClient) { }
  
  getAllAgents(): Observable<Agent[]> {
    return this.http.get<Agent[]>(this.findAllUrl).pipe(
      catchError(this.handleError)
    );
  }

  getAllAddresses(): Observable<Address[]> {
    return this.http.get<Address[]>(this.findAllAddressesUrl).pipe(
      catchError(this.handleError)
    );
  }

  saveAgent(request: CreateAgentRequest): Observable<Agent[]> {
    return this.http.post<Agent[]>(this.saveUrl, request).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(err: HttpErrorResponse) {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }

  
}
