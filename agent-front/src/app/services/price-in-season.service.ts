import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PriceInSeason } from '../model/priceInSeason.model';

@Injectable({
  providedIn: 'root'
})
export class PriceInSeasonService {

  constructor(private http : HttpClient) { }

  getPriceInSeasonByAcc(accId : number){
    return this.http.post<PriceInSeason[]>('api/accommodation/getPriceInSeason', accId);
  }

  addNewPriceInSeason(priceInSeason : PriceInSeason, accId : number){
    return this.http.post<PriceInSeason>('api/accommodation/addNewPriceInSeason', [priceInSeason, accId]);
  }
  deletePriceInSeason(ID_PIS : number){
    return this.http.post('api/accommodation/deletePriceInSeason', ID_PIS)
  }
}
