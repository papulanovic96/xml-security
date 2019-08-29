import { Injectable } from '@angular/core';
import { HttpErrorResponse, HttpClient } from '@angular/common/http';
import { throwError, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Comment, UpdateCommentRequest, CommentsUpdateResponse } from './comment';
@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private zuurl = 'http://localhost:8761/';

  private findComments = this.zuurl + 'main-backend/comments'
  private findRefusedUrl = this.zuurl + 'main-backend/comments/refused'
  private findAcceptedUrl = this.zuurl + 'main-backend/comments/approved'
  private acceptURL = this.zuurl + 'main-backend/comments/approve'
  private refuseURL = this.zuurl + 'main-backend/comments/refuse'
  private deleteURL = this.zuurl + 'main-backend/comments/delete/'

  private comment = new Comment(0, '', 0, '')

  private updateRequest = new UpdateCommentRequest;

  constructor(private http: HttpClient) { }

  getComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.findComments).pipe(
      catchError(this.handleError)
    );
  }

  getRefusedComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.findRefusedUrl).pipe(
      catchError(this.handleError)
    );
  }

  getAcceptedComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.findAcceptedUrl).pipe(
      catchError(this.handleError)
    );
  }

  approve(id: number): Observable<CommentsUpdateResponse> {
    this.updateRequest.id = id;
    return this.http.put<CommentsUpdateResponse>(this.acceptURL, this.updateRequest).pipe(
      catchError(this.handleError)
    );
  }

  refuse(id: number): Observable<CommentsUpdateResponse> {
    this.updateRequest.id = id;
    console.log(this.updateRequest);
    return this.http.put<CommentsUpdateResponse>(this.refuseURL, this.updateRequest).pipe(
      catchError(this.handleError)
    );
  }

  deleteComment(id: number): Observable<Object> {
    return this.http.delete(this.deleteURL + id).pipe(
      catchError(this.handleError)
    )
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
