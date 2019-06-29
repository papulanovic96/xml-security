import { Injectable } from '@angular/core';
import { Accommodation } from '../model/accommodation.model';
import { HttpClient } from '@angular/common/http';
import { AccommodationType } from '../model/AccommodationType.model';
import { AdditionalService } from '../model/additionalservice.model';
import { PriceInSeason } from '../model/priceInSeason.model';
import { Router, ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AccommodationService {

  currentAccs : Accommodation[] = [];
  editingAcc: Accommodation;

  constructor(private http : HttpClient, private router : Router, private route : ActivatedRoute) { 

  }

  getAllAccomodationTypes(){
    return this.http.get<AccommodationType[]>('api/accommodation/getAllAccTypes');
}
  getAllAccServices(){
    return this.http.get<AdditionalService[]>('api/accommodation/getAllAccServices');
  }

  getAllPrices(){
    return this.http.get<PriceInSeason[]>('api/accommodation/getAllPrices');
  }

  addNewAccommodation(acc: Accommodation){
    return this.http.post<any>('api/accommodation/addNewAccommodation', acc);
  }
  getAllAccommodations(){
    return this.http.get<Accommodation[]>('api/accommodation/getAllAcc');
  }
  setCurrentAccommodations(currentAccs : Accommodation[]){
    this.currentAccs = currentAccs;
  }
  deleteAcc(acc : Accommodation){
    return this.http.post<any>('api/accommodation/deleteAcc', acc.id);
  }

  setEditingAcc(acc : Accommodation){
    this.editingAcc = acc;
    
  }
  getEditingAcc(){
    return this.editingAcc;
  }
}
