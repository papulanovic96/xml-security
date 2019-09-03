import { Component, OnInit } from '@angular/core';
import { EndUser } from './end-user';
import { EndUserService } from './end-user.service';
import { CommentService } from '../comment/comment.service';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-end-user',
  templateUrl: './end-user.component.html',
  styleUrls: ['./end-user.component.css']
})
export class EndUserComponent implements OnInit {

  endUsers: EndUser[];
  endUser = new EndUser(0, '', '', '', '', '', 0,);
  isAdmin: boolean;

  constructor(private endUserService: EndUserService,
              private commentService: CommentService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.endUserService.getEndUsers().subscribe(
      endUsers => this.endUsers = endUsers
    );

    if (this.tokenStorage.getAuthorities().includes('ROLE_ADMIN'))
      this.isAdmin = true;
  }

  activate(username: string) {
    this.endUserService.activateEndUser(username).subscribe( response => this.endUsers = response );
  }

  block(username: string) {
    this.endUserService.blockEndUser(username).subscribe( response => this.endUsers = response );
  }

  delete(endUser: EndUser) {
    this.commentService.deleteComment(endUser.id).subscribe();
    this.endUserService.deleteEndUser(endUser.username).subscribe( response => this.endUsers = response );
  }

}
