import { OnInit, Injectable } from '@angular/core'
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AccommodationType, CreateAccommodationTypeRequest, DeleteAccommodationTypeRequest } from './accommodation-type';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError} from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class AccommodationTypeService implements OnInit {
    
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': 'my-auth-token'
        })
    }

    private zuurl = 'http://localhost:8761/';

    private createRequest = new CreateAccommodationTypeRequest;

    private saveTypeURL = this.zuurl + 'main-backend/accommodation-types';
    private deleteTypeURL = this.zuurl +'main-backend/accommodation-types/delete/';
    private getTypeURL: string;

    constructor(private http: HttpClient) {
        this.getTypeURL =  this.zuurl +'main-backend/accommodation-types';
    }

    getTypes(): Observable<AccommodationType[]> {
        return this.http.get<AccommodationType[]>(this.getTypeURL, this.httpOptions).pipe(
            catchError(this.handleError)
        )
    }    

    deleteType(name:string): Observable<AccommodationType[]> {
        return this.http.delete<AccommodationType[]>(this.deleteTypeURL + name).pipe(
            catchError(this.handleError)
        );
    }

    addType(newType: AccommodationType): Observable<AccommodationType[]> {
        this.createRequest.name = newType.name;
        return this.http.post<AccommodationType[]>(this.saveTypeURL, this.createRequest, {responseType: 'json'}).pipe(
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