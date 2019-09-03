import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Message, CreateMessageRequest } from '../model/message.model';
import { Observable } from 'rxjs';
import { EndUser } from '../model/endUser.model';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  
  private zuurl: string;

  constructor(private http : HttpClient) { 
    this.zuurl = 'https://localhost:8443/';
  }

  public sendMessage(message : CreateMessageRequest) : Observable<Message[]> {
    return this.http.post<Message[]>(this.zuurl + "agent-backend/messages/", message);
  }

  public inbox() : Observable<EndUser[]> {
    return this.http.get<EndUser[]>(this.zuurl + "agent-backend/messages/inbox/");
  }

  public chat(withClient : string) : Observable<Message[]> {
    return this.http.get<Message[]>(this.zuurl + "agent-backend/messages/history/" + withClient);
  }


}
