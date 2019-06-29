import { Injectable } from '@angular/core';
import { HttpErrorResponse, HttpClient } from '@angular/common/http';
import { throwError, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Comment } from './comment';
@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private findAllURL = 'http://localhost:4200/comment/notReviewed'
  private findAllacceptedURL = 'http://localhost:4200/comment/accepted'
  private acceptURL = 'http://localhost:4200/comment/accept'
  private refuseURL = 'http://localhost:4200/comment/refuse'

  private comment = new Comment(0, '', 0, 0)

  constructor(private http: HttpClient) { }

  getComment(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.findAllURL).pipe(
      catchError(this.handleError)
    );
  }

  getCommentAccepted(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.findAllacceptedURL).pipe(
      catchError(this.handleError)
    );
  }

  acceptComment(id: number): Observable<Object> {
    return this.http.put<number>(this.acceptURL + '/' + id, this.comment, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    );
  }

  blockComment(id: number): Observable<Object> {
    return this.http.put<number>(this.refuseURL + '/' + id, this.comment, {responseType: 'text'}).pipe(
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
