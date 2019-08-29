import { Injectable, OnInit } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError, Observable } from 'rxjs';
import { AccommodationCategory, CreateAccommodationCategoryRequest, UpdateAccommodationCategoryRequest, DeleteAccommodationCategoryRequest } from './accommodation-category';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AccommodationCategoryService implements OnInit {

  private zuurl = 'http://localhost:8761/';
  private createCategoryURL = this.zuurl + 'main-backend/accommodation-categories';
  private updateCategoryURL = this.zuurl + 'main-backend/accommodation-categories';
  private deleteCategoryURL = this.zuurl + 'main-backend/accommodation-categories/delete/';
  private getCategoriesURL = this.zuurl + 'main-backend/accommodation-categories';
  private getCategoryURL = this.zuurl + 'main-backend/accommodation-categories/find/';

  private createRequest: CreateAccommodationCategoryRequest;

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<AccommodationCategory[]> {
    return this.http.get<AccommodationCategory[]>(this.getCategoriesURL).pipe(
        catchError(this.handleError)
    )
  } 
  getCategory(id: number): Observable<AccommodationCategory> {
    return this.http.get<AccommodationCategory>(this.getCategoryURL + id).pipe(
        catchError(this.handleError)
    )
  }   

  createCategory(newCat: string): Observable<AccommodationCategory[]> {
    this.createRequest = new CreateAccommodationCategoryRequest();
    this.createRequest.name = newCat;
    return this.http.post<AccommodationCategory[]>(this.createCategoryURL, this.createRequest).pipe(
        catchError(this.handleError)
    );
  }

  deleteCategory(name : string) : Observable<AccommodationCategory[]> {
    return this.http.delete<AccommodationCategory[]>(this.deleteCategoryURL + name);
  }
  
  updateCategory(update : UpdateAccommodationCategoryRequest) : Observable<AccommodationCategory[]> {
    return this.http.put<AccommodationCategory[]>(this.updateCategoryURL, update);
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
    alert(errorMessage)
    return throwError(errorMessage);
  }
}
