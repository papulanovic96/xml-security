import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';

import { AccommodationService } from '../services/accommodation.service';
import { ReservationService } from '../services/reservation.service';

import { Accommodation } from '../model/accommodation.model';
import { CreateReservationRequest } from '../model/reservation.model';
import { Agent } from '../model/agent.model';

import { isNgTemplate } from '@angular/compiler';




@Component({ 
  selector: 'app-accommodation',
  templateUrl: './accommodation.component.html',
  styleUrls: ['./accommodation.component.css'],
  styles: [` 
  .rating {
    font-size: 48px;
    color: orange;
    display: inline-block;
    overflow: hidden;
  }
  .rating::before { 
    content: "★★★★★" 
  }
  `],
  providers: [DatePipe]
})
export class AccommodationComponent implements OnInit {

  accommodation: Accommodation;
  accommodations: Accommodation[];
  filteredAccommodations: Accommodation[];
  reservation: CreateReservationRequest;
 
  private _rate: number;

  images = [1, 2, 3].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`);

  private searchName: string;
  private searchType: string;
  private searchCategory: string;
  private searchCapacity: string;
  private searchAS: string;
  private searchDistance: string;
  private searchPrice: string;
  private searchFromDate: Date;
  private searchTillDate: Date;

  private today: Date;
  private minDate: string;
  private minDateTill: string;

  public _selectedFrom: Date;
  public _selectedTill: Date;
  
  constructor(private accommodationService: AccommodationService,
              private reservationService: ReservationService,
              private datePipe: DatePipe) { }
  
  get selectedFrom(): Date {
    return this._selectedFrom;
  }             
  
  get selectedTill(): Date {
    return this._selectedTill;
  }
 
  set selectedFrom(date : Date) {
    this._selectedFrom = date;
  }

  set selectedTill(date : Date) {
    this._selectedTill = date;
  }

  sortByCategory() : void {
    this.accommodations.sort((a,b) => a.category.name.localeCompare(b.category.name));
  }
  
  sortByType() : void {
    this.accommodations.sort((a,b) => a.type.name.localeCompare(b.type.name));
  }
  

  sortByDistance() : void {
    this.accommodations.sort((a,b) => a.distance - b.distance);
  }

  sortByRating() : void {
    this.accommodations.sort((a,b) => a.rate - b.rate);
  }
  
  ngOnInit() {
      this.today = new Date();
      this.minDate = this.datePipe.transform(this.today, 'yyyy-MM-dd');
      this.minDateTill = this.datePipe.transform(this.today, 'yyyy-MM-dd');

      this.accommodationService.getAccommodations().subscribe(
        data => { 
                  this.accommodations = data;
                }
      )
  }

  reserve(index : string) : void  {
    this.accommodation = this.accommodations[index];
    this.reservation = new CreateReservationRequest();
    this.reservation.accommodationName = this.accommodation.name;

    if (this.selectedFrom != null) 
        this.reservation.fromDate = this.selectedFrom;
    if (this.selectedTill != null) 
        this.reservation.tillDate = this.selectedTill;
    
    console.log(this.reservation)
    this.reservationService.create(this.reservation).subscribe(
      data => {
         alert(data.feedback)
      },
      err => {
        alert(err.error.message)
      }
  
    )
  }
}
