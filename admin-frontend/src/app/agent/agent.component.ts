import { Component, OnInit } from '@angular/core';
import { Agent, CreateAgentRequest } from './agent.model';
import { AgentService } from './agent.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Address, AgentAddress } from '../address.model';
import { TokenStorageService } from '../auth/token-storage.service';

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
  isAdmin: boolean;

  constructor(private agentService: AgentService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.agentService.getAllAgents().subscribe(
      response =>  { this.agents = response, console.log(response) }
    )
    this.agentService.getAllAddresses().subscribe(
      addresses => this.addresses = addresses
    )

    if (this.tokenStorage.getAuthorities().includes('ROLE_ADMIN'))
      this.isAdmin = true;
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
