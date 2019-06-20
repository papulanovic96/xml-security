import { EndUser } from './endUser.model';
import { Agent } from './agent.model';

export class Message{

    id : number;
    agent: Agent;
    endUser: EndUser;
    content: string="";

}