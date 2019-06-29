import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AdditionalServices } from './additional-services';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdditionalServicesService implements OnInit{

  private findAllURL = 'http://localhost:4200/additional-services/findAll'
  private deleteByIdURL = 'http://localhost:4200/additional-services/delete'
  private saveURL = 'http://localhost:4200/additional-services/save'

  constructor(private http: HttpClient) { }

  getAdditionalServices(): Observable<AdditionalServices[]> {
    return this.http.get<AdditionalServices[]>(this.findAllURL).pipe(
      catchError(this.handleError)
    )
  }

  deleteService(serviceId: number): Observable<Object> {
    return this.http.delete(this.deleteByIdURL + '/' + serviceId, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    );
  } 

  addService(service: AdditionalServices): Observable<AdditionalServices> {
    return this.http.post<AdditionalServices>(this.saveURL, service, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    );
  }

  ngOnInit() {
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
