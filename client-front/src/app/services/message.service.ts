import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Observable, throwError} from 'rxjs';
import { Message } from '../model/message.model';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private zuurl: string;

  constructor(private http: HttpClient) {
    this.zuurl = 'http://localhost:8761';
  }

  public sendMessage(message : Message) {
    return this.http.post<Message>(this.zuurl + "/main-backend/message/send", message);
  }

  public inbox() : Observable<Message[]> {
    return this.http.get<Message[]>(this.zuurl + "/main-backend/message/inbox");
  }

  public chat(withAgent : string) : Observable<Message[]> {
    return this.http.get<Message[]>(this.zuurl + "/main-backend/message/history/" + withAgent);
  }

}
