import { Component, OnInit } from '@angular/core';
import { EndUser } from './end-user';
import { EndUserService } from './end-user.service';

@Component({
  selector: 'app-end-user',
  templateUrl: './end-user.component.html',
  styleUrls: ['./end-user.component.css']
})
export class EndUserComponent implements OnInit {

  endUsers: EndUser[];
  endUser = new EndUser(0, '', '', '', '', '', 0, 0, 0);

  constructor(private endUserService: EndUserService) { }

  ngOnInit() {
    this.endUserService.getEndUsers().subscribe(
      endUsers => this.endUsers = endUsers
    );
  }

  activate(username: string) {
    this.endUserService.activateEndUser(username).subscribe();
    window.location.reload();
  }

  block(username: string) {
    this.endUserService.blockEndUser(username).subscribe();
    window.location.reload();
  }

}
