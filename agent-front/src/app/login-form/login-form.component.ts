import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from '../model/message.model';
import { User } from '../model/user.model';
import { AuthentService } from '../services/AuthentService';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Agent } from '../model/agent.model';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  agent : Agent = new Agent();
  error : string;
  constructor(private authent:AuthentService, private router: Router, private http : HttpClient) { }

  ngOnInit() {
   
  }
 
   loginClick(){
    this.authent.login(this.agent).subscribe(
      success=>{
          if(!success){
              this.error = "Wrong username or password";
          }else{
            this.router.navigate(["/home"]);
           
          }
    }
    );
   }
    
  
}
