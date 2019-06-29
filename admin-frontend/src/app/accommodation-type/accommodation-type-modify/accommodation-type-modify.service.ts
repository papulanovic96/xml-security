import { Injectable, OnInit } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AccommodationType } from '../accommodation-type';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AccommodationTypeModifyService implements OnInit{

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

  private findAllURL = 'http://localhost:4200/accommodation-type/findAll';
  private modifyURL = 'http://localhost:4200/accommodation-type/modify';

  constructor(private http: HttpClient) { }

  getTypes(): Observable<AccommodationType[]> {
    return this.http.get<AccommodationType[]>(this.findAllURL).pipe(
      catchError(this.handleError)
    );
  }

  updateType(id: number, aType: AccommodationType): Observable<Object> {
    return this.http.put<number>(this.modifyURL + '/' + id, aType, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    );
  }

  getTypeById(id: number): Observable<AccommodationType | undefined> {
    return this.getTypes().pipe(
      map((theTypes: AccommodationType[]) => theTypes.find(s => s.id === id))
    );
  }

  ngOnInit(): void {
    throw new Error("Method not implemented.");
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
