import { Injectable, OnInit } from '@angular/core';
import { HttpErrorResponse, HttpHeaders, HttpClient } from '@angular/common/http';
import { throwError, Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { AccommodationCategory } from '../accommodation-category';

@Injectable({
  providedIn: 'root'
})
export class AccommodationCategoryModifyService implements OnInit{

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

  private findAllURL = 'http://localhost:4200/accommodation-category/findAll';
  private modifyURL = 'http://localhost:4200/accommodation-category/modify';

  constructor(private http: HttpClient) { }

  getCategories(): Observable<AccommodationCategory[]> {
    return this.http.get<AccommodationCategory[]>(this.findAllURL).pipe(
      catchError(this.handleError)
    );
  }

  updateCategory(id: number, aCategory: AccommodationCategory): Observable<Object> {
    return this.http.put<number>(this.modifyURL + '/' + id, aCategory, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    );
  }

  getCategoryID(id: number): Observable<AccommodationCategory | undefined> {
    return this.getCategories().pipe(
      map((categories: AccommodationCategory[]) => categories.find(s => s.id === id))
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
