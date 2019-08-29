import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Observable, throwError} from 'rxjs';
import { CreateCommentRequest, CreateCommentResponse } from '../model/comment.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private zuurl: string;

  constructor(private http: HttpClient) {
    this.zuurl = 'http://localhost:8761';
  }

  public postComment(comment: CreateCommentRequest) {
    return this.http.post<CreateCommentResponse>(this.zuurl + "/main-backend/comments" ,comment);
  }


}
