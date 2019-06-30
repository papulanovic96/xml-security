import { Component, OnInit } from '@angular/core';

import { UsersService } from '../../services/users.service';
import { MessageService } from '../../services/message.service';
import { CommentService } from '../../services/comment.service';


import { Reservation } from "../../model/reservation.model";
import { Agent } from 'src/app/model/agent.model';
import { Message } from '../../model/message.model';
import { Comment } from '../../model/comment.model';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css'],
  styles: [`textarea {
    resize: none;
  }
  .rating {
    font-size: 48px;
    color: orange;
    display: inline-block;
    overflow: hidden;
  }
  .rating::before { 
    content: "★★★★★" 
  }`]  
})
export class AccountComponent implements OnInit {

  reservations: Reservation[];
  reservation: Reservation;

  message: Message;
  inbox: Message[];
  chat: Message[];

  comment: Comment;
 
  _messageContent: string;
  _commentContent: string;

  constructor(private userService: UsersService,
              private messageService: MessageService,
              private commentService: CommentService) { }

  get messageContent() : string { 
    return this._messageContent;
  }

  set messageContent(c : string) {
    this._messageContent = c;
  }

  get commentContent() : string { 
    return this._commentContent;
  }

  set commentContent(c : string) {
    this._commentContent = c;
  }

  ngOnInit() {
    this.userService.findMyReservations().subscribe(
      data => {
        this.reservations = data;
        console.log(this.reservations)
      },
      err => {
        console.log(err.error)
      }
    )
  }

  postComment(accommodationId: string) : void{

    this.comment = new Comment();
    
    this.comment.content = this.commentContent;

    this.commentService.postComment(this.comment, accommodationId).subscribe(
      data => {
        alert(data.content)
      },
      err =>{

      })

  }

  sendMessage(recipient : string) : void {

    this.message = new Message();

    this.message.content = this.messageContent;
    this.message.recipientUsername = recipient;

    this.messageService.sendMessage(this.message).subscribe( 
      data => {
        alert(data)
    },
      err => {
        alert(err.error)
    })
  }

  getMyInbox() : void {
    this.messageService.inbox().subscribe( 
      data => {
        this.inbox = data;
    },
      err => {

    })
  }

  getMyChatHistory(withAgent: string) : void {
    this.messageService.chat(withAgent).subscribe( 
      data => {
        console.log(this.chat)
        this.chat = data;
    },
      err => {

    })
  }


}
