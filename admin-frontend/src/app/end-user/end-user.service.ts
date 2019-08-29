import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { EndUser, UserResponse } from './end-user';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EndUserService {

  private zuurl = "http://localhost:8761/"

  private findAllUrl = this.zuurl + 'main-backend/users/find/endusers';
  private activateURL = this.zuurl + 'main-backend/users/activate/';
  private blockURL = this.zuurl + 'main-backend/users/block/';
  private deleteURL = this.zuurl + 'main-backend/users/delete/';

  constructor(private http: HttpClient) { }

  getEndUsers(): Observable<EndUser[]> {
    return this.http.get<EndUser[]>(this.findAllUrl).pipe(
      catchError(this.handleError)
    );
  }

  activateEndUser(username: string): Observable<EndUser[]> {
    return this.http.put<EndUser[]>(this.activateURL + username, null).pipe(
      catchError(this.handleError)
    );
  }

  blockEndUser(username: string): Observable<EndUser[]> {
    return this.http.put<EndUser[]>(this.blockURL + username, null).pipe(
      catchError(this.handleError)
    );
  }

  deleteEndUser(username: string): Observable<EndUser[]> {
    return this.http.delete<EndUser[]>(this.deleteURL + username).pipe(
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
