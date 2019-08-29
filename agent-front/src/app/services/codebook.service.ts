import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AccommodationCategory } from '../model/accommodationCategory.model';
import { AccommodationType } from '../model/accommodationType.model';
import { AdditionalService } from '../model/additionalservice.model';

@Injectable({
  providedIn: 'root'
})
export class CodebookService {

  private zuurl = 'http://localhost:8761/'
  
  private categoriesUrl = 'agent-backend/accommodation-categories'
  private typesUrl = 'agent-backend/accommodation-types'
  private additionalServicesUrl = 'agent-backend/additional-services'


  constructor(private http: HttpClient) { }

  getCategories() : Observable<AccommodationCategory[]> {
    return this.http.get<AccommodationCategory[]>(this.zuurl + this.categoriesUrl)
  }

  getTypes() : Observable<AccommodationType[]> {
    return this.http.get<AccommodationType[]>(this.zuurl + this.typesUrl)
  }
  
  getAdditionalServices() : Observable<AdditionalService[]> {
    return this.http.get<AdditionalService[]>(this.zuurl + this.additionalServicesUrl)
  }
}
