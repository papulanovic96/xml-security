import { Injectable, OnInit } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError, Observable } from 'rxjs';
import { AccommodationCategory } from './accommodation-category';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AccommodationCategoryService implements OnInit{

  httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'my-auth-token'
    })
}

private saveCategoryURL = 'http://localhost:4200/accommodation-category/save';
private deleteCategoryURL = 'http://localhost:4200/accommodation-category/delete';
private getCategoryURL: string;

  constructor(private http: HttpClient) {
    this.getCategoryURL = 'http://localhost:4200/accommodation-category/findAll';
   }

  getCategories(): Observable<AccommodationCategory[]> {
    return this.http.get<AccommodationCategory[]>(this.getCategoryURL, this.httpOptions).pipe(
        catchError(this.handleError)
    )
}    

deleteCategory(id:number): Observable<Object> {
    return this.http.delete(this.deleteCategoryURL + '/' + id, {responseType: 'text'}).pipe(
        catchError(this.handleError)
    );
}

addCategory(newCat: AccommodationCategory): Observable<AccommodationCategory> {
    return this.http.post<AccommodationCategory>(this.saveCategoryURL, newCat, {responseType: 'text'}).pipe(
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
