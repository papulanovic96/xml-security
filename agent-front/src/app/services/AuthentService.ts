import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { HttpClient } from '@angular/common/http';
import { tap, mapTo, catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import * as JWT from 'jwt-decode';
import { Router } from '@angular/router';
import { Message } from '../model/message.model';
import { User } from '../model/user.model';
import { Agent } from '../model/agent.model';

@Injectable({
    providedIn: 'root',
})

export class AuthentService{

    constructor(private http : HttpClient, private router : Router){
    }
    login(agent : Agent):Observable<boolean>{

        return this.http.post<any>("/api/agent/login", {username : agent.username, password: agent.password}).pipe(
           // tap(response => this.doLoginUser(response)),
            mapTo(true),
            catchError(error => {
              
              return of(false);
            }));

    }
        doLoginUser(response){
            localStorage.setItem("JWT_TOKEN", response.jwt);
        }

        logOutUser(){    
        //this.http.get('api/logOut').subscribe(
         //   data => {})
        
        localStorage.removeItem("JWT_TOKEN");
        this.router.navigateByUrl('/login')
      
        } /*
    isUserLogged() : boolean{
        let jwt = localStorage.getItem("JWT_TOKEN");
        if(jwt == null) return false;
        else if(!this.isTokenExpired()) return true;
    }

    getJwt() : string{
        return localStorage.getItem("JWT_TOKEN");
    }

    getTokenExpirationDate(token: string): Date {
       
        const decoded = JWT(token);
      
       

        if (decoded.exp === undefined) return null;

        const date = new Date(0); 
        date.setUTCSeconds(decoded.exp);
        return date;
    }
    
    isTokenExpired(token?: string): boolean {
        if(!token) token = this.getJwt();
        if(!token) return true;
    
        const date = this.getTokenExpirationDate(token);
        if(date === undefined) return false;
        return !(date.valueOf() > new Date().valueOf());
    }*/

}