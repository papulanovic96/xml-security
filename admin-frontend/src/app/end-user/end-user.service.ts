import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { EndUser } from './end-user';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EndUserService {

  private findAllUrl = 'http://localhost:4200/end-user-action/findAll';
  private activateURL = 'http://localhost:4200/end-user-action/activate';
  private blockURL = 'http://localhost:4200/end-user-action/block';
  private deleteURL = 'http://localhost:4200/end-user-action/delete';

  constructor(private http: HttpClient) { }

  getEndUsers(): Observable<EndUser[]> {
    return this.http.get<EndUser[]>(this.findAllUrl).pipe(
      catchError(this.handleError)
    );
  }

  activateEndUser(username: string): Observable<Object> {
    return this.http.put<string>(this.activateURL + '/' + username, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    );
  }

  blockEndUser(username: string): Observable<Object> {
    return this.http.put<string>(this.blockURL + '/' + username, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    );
  }

  deleteEndUser(username: string): Observable<Object> {
    return this.http.delete(this.deleteURL + '/' + username).pipe(
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
