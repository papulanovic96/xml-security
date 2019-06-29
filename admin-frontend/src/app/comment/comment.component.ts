import { Component, OnInit } from '@angular/core';
import { CommentService } from './comment.service';
import { Comment } from './comment';
@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  comments: Comment[];
  acceptedComments: Comment[];

  constructor(private serviceComment: CommentService) { }

  ngOnInit() {
    this.serviceComment.getComment().subscribe(
      comments => this.comments = comments
    );

    this.serviceComment.getCommentAccepted().subscribe(
      acceptedComments => this.acceptedComments = acceptedComments
    );
  }

  activate(id: number) {
    this.serviceComment.acceptComment(id).subscribe();
    this.serviceComment.getCommentAccepted().subscribe(acceptedComments => this.acceptedComments = acceptedComments);
    this.serviceComment.getComment().subscribe(comments => this.comments = comments);
  }

  block(id: number) {
    this.serviceComment.blockComment(id).subscribe();
    this.serviceComment.getCommentAccepted().subscribe(acceptedComments => this.acceptedComments = acceptedComments);
    this.serviceComment.getComment().subscribe(comments => this.comments = comments);
  }

}
