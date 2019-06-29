import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { FormControl, FormGroup, FormBuilder, NgModel } from '@angular/forms';

import { User } from 'src/app/model/user.model';

import { UsersService } from '../../services/users.service'; 
import { stringify } from '@angular/compiler/src/util';



@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  public image ='assets/gradient.jpg';
  private location: Location;

  private newUser: User;

  public userForm: FormGroup;

  public errorMessage: NgModel;

  constructor(private usersService : UsersService,
              private router: Router) {}

  ngOnInit() {
    this.userForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
      firstName: new FormControl(''),
      lastName: new FormControl(''),
      email: new FormControl('')
    })
  }

  get user() { 
    return this.userForm.controls; 
  }

  register() : void {

      this.newUser = new User();
      
      this.newUser.username = this.user.username.value;
      this.newUser.password = this.user.password.value;
      this.newUser.firstName =this.user.firstName.value;
      this.newUser.lastName = this.user.lastName.value;
      this.newUser.email = this.user.email.value;

      this.usersService.save(this.newUser).subscribe(
            data => { console.log("RES:  "+ data)
            this.location.replace('/siginin'); // clears browser history so they can't navigate with back button
            },
            err => { 
             alert(JSON.stringify(err.error))
            }
        )   
  }

 
}
