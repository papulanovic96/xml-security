import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Agent } from './agent.model';
import { catchError } from 'rxjs/operators';
import { AgentList } from './agent-list';

@Injectable({
  providedIn: 'root'
})
export class AgentService {

  private findAllUrl = 'http://localhost:4200/admin-agent-creation/findAgents';
  private saveUrl = 'http://localhost:4200/admin-agent-creation/saveAgent';

  constructor(private http: HttpClient) { }

  getAllAgents(): Observable<AgentList> {
    return this.http.get<AgentList>(this.findAllUrl).pipe(
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
