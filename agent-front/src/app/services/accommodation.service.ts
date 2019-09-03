import { Injectable } from '@angular/core';
import { Accommodation, CreateAccommodationRequest } from '../model/accommodation.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccommodationService {

  private zuurl = 'https://localhost:8443/'
  private accommodationUrl = 'agent-backend/accommodations/'

  currentAccs : Accommodation[] = [];
  editingAcc: Accommodation;

  constructor(private http : HttpClient) {}

  getThatIOwn(){
    return this.http.get<Accommodation[]>(this.zuurl + this.accommodationUrl + 'owned');
  }
  
  create(request: CreateAccommodationRequest) : Observable<Accommodation[]> {
    return this.http.post<Accommodation[]>(this.zuurl + this.accommodationUrl, request);
  }

  delete(acc : Accommodation) : Observable<Accommodation[]> {
    return this.http.delete<Accommodation[]>(this.zuurl + this.accommodationUrl + acc.name);
  }

  setCurrentAccommodations(currentAccs : Accommodation[]){
    this.currentAccs = currentAccs;
  }

  setEditingAcc(acc : Accommodation){
    this.editingAcc = acc;
    
  }
  getEditingAcc(){
    return this.editingAcc;
  }
}
