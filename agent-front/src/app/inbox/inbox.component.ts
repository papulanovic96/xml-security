import { Component, OnInit } from '@angular/core';

import { AgentService } from '../services/agent.service';
import { MessageService } from '../services/message.service';
import { EndUser } from '../model/endUser.model';
import { Message, CreateMessageRequest } from '../model/message.model';


@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit {

  clients: EndUser[];
  client: EndUser;

  chat: Message[];
  private message: string;
  private request: CreateMessageRequest;

  clientName = "";
  numberOfMessages: number;

  constructor(private messageService: MessageService) { }

  ngOnInit() {
    this.client = new EndUser();
    this.messageService.inbox().subscribe(
      response => { 
      console.log(response)
      this.clients = response;
      this.client = this.clients[0];
      this.messageService.chat(this.client.username).subscribe(
        response => { 
        console.log(response)
        this.chat = response;
        this.clientName = this.client.firstName + " " + this.client.lastName;
        this.numberOfMessages = this.chat.length;
        },
        error => { alert(error.error.message) 
      })
    },
      error => { alert("You didnt chat with anyone yet!")
    })
  }

  showHistory(i: number) {
    this.client = this.clients[i];
    this.messageService.chat(this.client.username).subscribe(
      response => { 
      this.chat = response;
      this.clientName = this.client.firstName + " " + this.client.lastName;
      this.numberOfMessages = this.chat.length;
    },
      error => { alert(error.error.message) })
  }
  
  sendMessage() { 

    this.request = new CreateMessageRequest();
    this.request.content = this.message;
    this.request.recipient = this.client.username;

    console.log(this.request)
    this.messageService.sendMessage(this.request).subscribe(
      response => {
        console.log(response)
        this.chat = response;
        this.message = "";
      },
      error => {
        alert(error.error.message)
      }
    )
  }

}
