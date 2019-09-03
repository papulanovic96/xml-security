import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../services/reservation.service';
import { Reservation, UpdateReservationRequest } from '../model/reservation.model';
import { AgentService } from '../services/agent.service';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  reservations: Reservation[]

  update: UpdateReservationRequest;

  isAgent: boolean;
  constructor(private reservationService: ReservationService,
              private agentService: AgentService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.agentService.findMyReservations().subscribe(
      data => {
        this.reservations = data;
      },
      err => {
        console.log(err.error)
      }
    )

    if (this.tokenStorage.getAuthorities().includes('ROLE_AGENT')) {
      this.isAgent = true;
    }
  }

  approve(rid : number) {
    this.update = new UpdateReservationRequest();
    this.update.id = rid;
    this.update.status = 'APPROVED';
    this.reservationService.approve(this.update).subscribe(
      response => this.reservations = response
    );
  }

  reject(rid : number) {
    this.update = new UpdateReservationRequest();
    this.update.id = rid;
    this.update.status = 'REJECTED';
    this.reservationService.reject(this.update).subscribe(
      response => this.reservations = response
    );
  }

}
