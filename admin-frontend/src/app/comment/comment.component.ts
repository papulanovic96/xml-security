import { Component, OnInit } from '@angular/core';
import { CommentService } from './comment.service';
import { Comment} from './comment';
import { TokenStorageService } from '../auth/token-storage.service';
@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  refusedComments: Comment[];
  acceptedComments: Comment[]
  isAdmin: boolean;

  constructor(private serviceComment: CommentService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.serviceComment.getAcceptedComments().subscribe(
      response => { this.acceptedComments = response }
    );
    this.serviceComment.getRefusedComments().subscribe(
      response => { this.refusedComments = response }
    );

    if (this.tokenStorage.getAuthorities().includes('ROLE_ADMIN'))
      this.isAdmin = true;
  }

  approve(id: number) {    
    this.serviceComment.approve(id).subscribe(
      response => { this.acceptedComments = response.approved
                    this.refusedComments = response.refused });
  }

  refuse(id: number) {
    this.serviceComment.refuse(id).subscribe(
       response => { this.acceptedComments = response.approved
                     this.refusedComments = response.refused; console.log(response) });
  }

}
