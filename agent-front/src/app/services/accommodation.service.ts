import { Injectable } from '@angular/core';
import { Accommodation } from '../model/accommodation.model';
import { HttpClient } from '@angular/common/http';
import { AccommodationType } from '../model/AccommodationType.model';
import { AdditionalService } from '../model/additionalservice.model';

@Injectable({
  providedIn: 'root'
})
export class AccommodationService {

  currentAcc : Accommodation[] = [];

  constructor(private http : HttpClient) { 

  }

  getAllAccomodationTypes(){
    return this.http.get<AccommodationType[]>('api/accommodation/getAllAccTypes');
}
  getAllAccServices(){
    return this.http.get<AdditionalService[]>('api/accommodation/getAllAccServices');
  }
}
