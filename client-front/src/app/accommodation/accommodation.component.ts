import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';

import { AccommodationService } from '../services/accommodation.service';
import { ReservationService } from '../services/reservation.service';

import { Accommodation } from '../model/accommodation.model';
import { Reservation } from '../model/reservation.model';
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
  reservation: Reservation;
 
  private _rate: number;

  private _searchName: string;
  private _searchType: string;
  private _searchCategory: string;
  private _searchCapacity: string;
  private _searchAS: string;
  private _searchDistance: string;
  private _searchPrice: string;

  private today: Date;
  private _selectedFromDate: Date;
  private _selectedTillDate: Date;
  private minDate: string;
  private minDateTill: string;

  public _selectedFrom: Date;
  public _selectedTill: Date;
  
  constructor(private accommodationService: AccommodationService,
              private reservationService: ReservationService,
              private datePipe: DatePipe) { }

  
  get rate(): number {
    return this._rate;
  } 

  get selectedFrom(): Date {
    return this._selectedFrom;
  }             
  get selectedTill(): Date {
    return this._selectedTill;
  }

  get selectedFromDate(): Date {
    return this._selectedFromDate;
  }             
  get selectedTillDate(): Date {
    return this._selectedTillDate;
  }
              
  get searchName(): string {
    return this._searchName;
  }

  get searchType(): string {
    return this._searchType;
  }

  get searchCategory(): string {
    return this._searchCategory;
  }

  get searchCapacity(): string {
    return this._searchCapacity;
  }

  get searchDistance(): string {
    return this._searchDistance;
  }

  get searchPrice(): string {
    return this._searchPrice;
  }

  get searchAS(): string {
    return this._searchAS;
  }

  set rate(rate : number) {
    this._rate = rate;
  }

  set selectedFrom(date : Date) {
    this._selectedFrom = date;
  }

  set selectedTill(date : Date) {
    this._selectedTill =  date;
  }

  set selectedFromDate(date : Date) {
    this.minDateTill = this.datePipe.transform(date, 'yyyy-MM-dd');
    this._selectedFromDate =  date;
    this.filteredAccommodations = this.filterAccommodationsFromDate(date);
  }

  set selectedTillDate(date : Date) {
    this._selectedTillDate =  date;
    this.filteredAccommodations = this.filterAccommodationsTillDate(date);
    this._selectedTillDate = date;
  }

  set searchName(entry : string) {
    this._searchName = entry;
    this.filteredAccommodations = this.filterAccommodationsName(entry);
  }

  set searchType(entry : string) {
    this._searchType = entry;
    this.filteredAccommodations = this.filterAccommodationsType(entry);
  }

  set searchCategory(entry : string) {
    this._searchCategory = entry;
    this.filteredAccommodations = this.filterAccommodationsCategory(entry);
  }

  set searchCapacity(entry : string) {
    this._searchCategory = entry;
    this.filteredAccommodations = this.filterAccommodationsCapacity(entry);
    if(entry.length == 0) 
      this.filteredAccommodations = this.accommodations;
  }

  set searchAS(entry : string) {
    this._searchAS = entry;
    this.filteredAccommodations = this.filterAccommodationsAS(entry);
  }

  set searchDistance(entry : string) {
    this._searchDistance = entry;
    this.filteredAccommodations = this.filterAccommodationsDistance(entry);
    if(entry.length == 0) 
      this.filteredAccommodations = this.accommodations;
  }

  set searchPrice(entry : string) {
    this._searchPrice = entry;
    this.filteredAccommodations = this.filterAccommodationsPrice(entry);
    if(entry.length == 0) 
      this.filteredAccommodations = this.accommodations;
  }

  filterAccommodationsFromDate(search : Date) { 
    return this.accommodations.filter(accommodation => accommodation.fromDate > search);
  }

  filterAccommodationsTillDate(search : Date) { 
    return this.accommodations.filter(accommodation => accommodation.fromDate < search);
  }

  filterAccommodationsName(search : string) { 
    return this.accommodations.filter(accommodation => accommodation.name.toLowerCase().indexOf(search.toLowerCase()) !== -1);
  }

  filterAccommodationsType(search : string) { 
    return this.accommodations.filter(accommodation => accommodation.type.name.toLowerCase().indexOf(search.toLowerCase()) !== -1);
  }

  filterAccommodationsCategory(search : string) { 
    return this.accommodations.filter(accommodation => accommodation.category.name.toLowerCase().indexOf(search.toLowerCase()) !== -1);
  }

  filterAccommodationsCapacity(search : string) { 
    return this.accommodations.filter(accommodation => accommodation.capacity >= search);
  }

  filterAccommodationsPrice(search : string) { 
    var price = +search;
    
    return this.accommodations.filter(accommodation => accommodation.priceInSeason.price <= price);
  }

  filterAccommodationsAS(search : string) { 
    return this.accommodations.filter(accommodation => accommodation.additionalService
                              .filter(addition =>  addition.name.toLowerCase().indexOf(search.toLowerCase()) !== -1));
  }

  filterAccommodationsDistance(search : string) { 
    var distance = +search;
    return this.accommodations.filter(accommodation => accommodation.distance <= distance);
  }
  
  sortByCategory() : void {
    this.accommodations.sort((a,b) => a.category.name.localeCompare(b.category.name));
  }
  
  sortByType() : void {
    this.accommodations.sort((a,b) => a.type.name.localeCompare(b.type.name));
  }
  
  sortByPrice() : void {
    this.accommodations.sort((a,b) => a.priceInSeason.price -  b.priceInSeason.price);
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
          console.log(data)
                  this.accommodations = data;
                  this.filteredAccommodations = data;
                }
      )
  }

  reserve(index : string) : void  {
    var position = +index;
    this.accommodation = this.accommodations.find(accommodation => (accommodation.id) === (position+1));
   
    this.reservation = new Reservation();
    this.reservation.accommodation = this.accommodation;

    if (this.selectedFrom != null) 
        this.reservation.fromDate = this.selectedFrom;
    if (this.selectedTill != null) 
        this.reservation.tillDate = this.selectedTill;
    
    console.log(this.reservation)
    this.reservationService.create(this.reservation).subscribe(
      data => {
          console.log(data)
      },
      err => {
        alert(err.error)
      }
  
    )
  }

 

  rating(rate : number) {
    var cw = document.getElementById("rating1").clientWidth; // save original 100% pixel width
    window.document.getElementById("rating1").style.width = Math.round(cw * (rate / 5)) + 'px';
  }


  }
