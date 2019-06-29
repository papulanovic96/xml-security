import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Observable, throwError} from 'rxjs';
import { Comment } from '../model/comment.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private zuurl: string;

  constructor(private http: HttpClient) {
    this.zuurl = 'http://localhost:8761';
  }

  public postComment(comment: Comment, id: string) {
    return this.http.post<Comment>(this.zuurl + "/main-backend/accommodation/comment/" + id ,comment);
  }


}
