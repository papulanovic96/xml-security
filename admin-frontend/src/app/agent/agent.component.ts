import { Component, OnInit } from '@angular/core';
import { Agent } from './agent.model';
import { AgentService } from './agent.service';
import { AgentList } from './agent-list';
import { AddressAgent } from './address';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.css']
})
export class AgentComponent implements OnInit {

  agentsList: Agent[] = [];
  addresses: AddressAgent[] = [];
  oneAndOnlyAddress = new AddressAgent('', '', 0, '', 0, 0);
  agent = new Agent(0, '', '', '', '', '', 0, this.oneAndOnlyAddress);
  agL = new AgentList(this.agentsList);

  constructor(private agentService: AgentService) { }

  ngOnInit() {
    this.agentService.getAllAgents().subscribe(
      agentsList => { this.agentsList = agentsList}
    );

    this.agentService.getAllAddresses().subscribe(
      addresses => {this.addresses = addresses}
    );
  }

  onSubmit() {
    this.agentService.saveAgent(this.agent).subscribe(
      agent => this.agentsList.push(agent)
    );
    this.agentService.saveAddress(this.oneAndOnlyAddress).subscribe(
      oneAndOnlyAddress => this.agent.address_id = oneAndOnlyAddress
    );
    window.location.reload();
  }

}
