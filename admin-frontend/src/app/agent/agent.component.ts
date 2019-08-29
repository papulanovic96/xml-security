import { Component, OnInit } from '@angular/core';
import { Agent, CreateAgentRequest } from './agent.model';
import { AgentService } from './agent.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Address, AgentAddress } from '../address.model';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.css']
})
export class AgentComponent implements OnInit {

  agents: Agent[];
  addresses: Address[]

  agent = new CreateAgentRequest;
  city: string;

  constructor(private agentService: AgentService) { }

  ngOnInit() {
    this.agentService.getAllAgents().subscribe(
      response =>  { this.agents = response, console.log(response) }
    )
    this.agentService.getAllAddresses().subscribe(
      addresses => this.addresses = addresses
    )
  }

  onSubmit() {
    this.agent.city = this.city;
    this.agentService.saveAgent(this.agent).subscribe(
      response =>  { this.agentService.getAllAgents().subscribe(
        response =>  { this.agents = response, console.log(response) }
      )}
    );
  }

}
