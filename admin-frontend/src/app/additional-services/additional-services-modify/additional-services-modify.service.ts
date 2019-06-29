import { Injectable, OnInit } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AdditionalServices } from '../additional-services';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdditionalServicesModifyService implements OnInit{
 
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

  private findAllURL = 'http://localhost:4200/additional-services/findAll';
  private modifyURL = 'http://localhost:4200/additional-services/modify';


  constructor(private http: HttpClient) { }

  getServices(): Observable<AdditionalServices[]> {
    return this.http.get<AdditionalServices[]>(this.findAllURL).pipe(
      catchError(this.handleError)
    );
  }

  updateService(id: number, aService: AdditionalServices): Observable<Object> {
    return this.http.put<number>(this.modifyURL + '/' + id, aService, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    );
  }

  getOneService(id: number): Observable<AdditionalServices | undefined> {
    return this.getServices().pipe(
      map((servicess: AdditionalServices[]) => servicess.find(s => s.id === id))
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
