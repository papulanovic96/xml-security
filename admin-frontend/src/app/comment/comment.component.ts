import { Component, OnInit } from '@angular/core';
import { CommentService } from './comment.service';
import { Comment} from './comment';
@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  refusedComments: Comment[];
  acceptedComments: Comment[]

  constructor(private serviceComment: CommentService) { }

  ngOnInit() {
    this.serviceComment.getAcceptedComments().subscribe(
      response => { this.acceptedComments = response }
    );
    this.serviceComment.getRefusedComments().subscribe(
      response => { this.refusedComments = response }
    );
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
