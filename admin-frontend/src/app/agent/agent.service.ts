import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Agent } from './agent.model';
import { catchError, map } from 'rxjs/operators';
import { AgentList } from './agent-list';
import { AddressAgent } from './address';

@Injectable({
  providedIn: 'root'
})
export class AgentService {

  private findAllUrl = 'http://localhost:4200/admin-agent-creation/findAgents';
  private saveUrl = 'http://localhost:4200/admin-agent-creation/saveAgent';
  private findAllAddressesUrl = 'http://localhost:4200/address/findAll';
  private saveItUrl = 'http://localhost:4200/address/save';

  constructor(private http: HttpClient) { }
  
  getAllAgents(): Observable<Agent[]> {
    return this.http.get<Agent[]>(this.findAllUrl).pipe(
      catchError(this.handleError)
    );
  }

  getAllAddresses(): Observable<AddressAgent[]> {
    return this.http.get<AddressAgent[]>(this.findAllAddressesUrl).pipe(
      catchError(this.handleError)
    );
  }

  getAddress(id: number): Observable<Agent | undefined> {
    return this.getAllAgents().pipe(
      map((servicess: Agent[]) => servicess.find(s => s.id === id))
    );
  }

  saveAddress(newAddress: AddressAgent): Observable<AddressAgent> {
    return this.http.post<AddressAgent>(this.saveItUrl, newAddress, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    );
  }

  saveAgent(newAgent: Agent): Observable<Agent> {
    return this.http.post<Agent>(this.saveUrl, newAgent, {responseType: 'text'}).pipe(
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
