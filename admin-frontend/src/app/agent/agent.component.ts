import { Component, OnInit } from '@angular/core';
import { Agent } from './agent.model';
import { AgentService } from './agent.service';
import { AgentList } from './agent-list';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.css']
})
export class AgentComponent implements OnInit {

  agentsList: Agent[] = [];
  agent = new Agent(0, '', '', '', '', '', 0, 0, 0);
  agL = new AgentList(this.agentsList);

  constructor(private agentService: AgentService) { }

  ngOnInit() {
    this.agentService.getAllAgents().subscribe(
      agentsList => { this.agL = agentsList}
    )
  }

  onSubmit() {
    this.agentService.saveAgent(this.agent).subscribe(
      agent => this.agentsList.push(agent)
    );
  }

}
