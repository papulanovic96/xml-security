import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'; 
import { Observable } from 'rxjs';
import { Message } from './model/message.model';
import { User } from './model/user.model';

const httpOptions = {
  headers: new HttpHeaders({
      'Content-Type': 'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})
export class DataService {


  constructor(private http: HttpClient) { }
 
}
