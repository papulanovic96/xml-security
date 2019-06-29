import { Component, OnInit } from '@angular/core';

import { UsersService } from '../services/users.service'; 
import { User } from '../model/user.model';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[];

  constructor(private usersService : UsersService) { }

  ngOnInit() {
    
    this.usersService.getUsers().subscribe(data => {
      console.log(data)
      this.users = data;
    });
       
  }

}
