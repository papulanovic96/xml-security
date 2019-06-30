import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { FormControl, FormGroup, FormBuilder, NgModel } from '@angular/forms';

import { User } from 'src/app/model/user.model';

import { UsersService } from '../../services/users.service'; 
import { AuthService } from '../../auth/auth.service';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';

  public image ='assets/gradient.jpg';
  private location: Location;

  private newUser: User;

  public signupInfo: FormGroup;

  constructor(private usersService : UsersService,
              private router: Router,
              private authService: AuthService) {}

  ngOnInit() {
    this.signupInfo = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
      firstName: new FormControl(''),
      lastName: new FormControl(''),
      email: new FormControl('')
    })
  }

  get user() { 
    return this.signupInfo.controls; 
  }

  register() : void {

      this.newUser = new User();
      
      this.newUser.username = this.user.username.value;
      this.newUser.password = this.user.password.value;
      this.newUser.firstName =this.user.firstName.value;
      this.newUser.lastName = this.user.lastName.value;
      this.newUser.email = this.user.email.value;

      this.authService.signUp(this.newUser).subscribe(
        data => {
          console.log(data);
          this.isSignedUp = true;
          this.isSignUpFailed = false;
        },
        error => {
          console.log(error);
          this.errorMessage = error.error.message;
          this.isSignUpFailed = true;
        }
      );  
  }

 
}
