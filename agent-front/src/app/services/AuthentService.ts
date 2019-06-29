import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { tap, mapTo, catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { Router } from '@angular/router';
import { User } from '../model/user.model';
import { Agent } from '../model/agent.model';

@Injectable({
    providedIn: 'root',
})

export class AuthentService{

    loggedUser:User = new User();

    constructor(private http : HttpClient, private router : Router){
    }
    login(agent : Agent):Observable<boolean>{

        return this.http.post<any>("/api/agent/login", {username : agent.username, password: agent.password})
        .pipe(
        
            mapTo(true),
            catchError(error => {
              
              return of(false);
            }));

    }
        

        logOutUser(){    
       
        this.router.navigateByUrl('/login')
  
        } 

}