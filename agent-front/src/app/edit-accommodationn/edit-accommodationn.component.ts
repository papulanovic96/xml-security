import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/accommodation.model';
import { Image } from '../model/image.model';
import { AccommodationService } from '../services/accommodation.service';
import { PriceInSeason } from '../model/priceInSeason.model';
import { ImageService } from '../services/image.service';
import { PriceInSeasonService } from '../services/price-in-season.service';
import { Reservation } from '../model/reservation.model';
import { ReservationService } from '../services/reservation.service';
import { Months } from '../model/months.enum';
import { Currencies } from '../model/currencies.enum';

@Component({
  selector: 'app-edit-accommodationn',
  templateUrl: './edit-accommodationn.component.html',
  styleUrls: ['./edit-accommodationn.component.css']
})
export class EditAccommodationnComponent implements OnInit {

  acc:Accommodation = new Accommodation();
  images : String[] = [];
  pricesInSeason : PriceInSeason[] = [];
  reservations : Reservation[] = [];
  ppErrorMessage : string = "";
  months= Months;
  selectedMonth = Months.JANUARY;
  currencies= Currencies;
  selectedCurrency = Currencies.EUR;
  newPriceInSeason: PriceInSeason = new PriceInSeason();
  
  constructor(private accService : AccommodationService, 
              private imgService : ImageService, 
              private pisService : PriceInSeasonService, 
              private reservationService : ReservationService) { 
    this.acc = accService.getEditingAcc();
    this.loadAcc();
  }

  ngOnInit() {

  }

  keysCurrencies():Array<string>{
    var keys = Object.keys(this.currencies);
    return keys;
  }  
  keysMonths():Array<string>{
    var keys = Object.keys(this.months);
    return  keys;
  } 


  loadAcc(){

    this.images = [];
   
    this.imgService.getImagesIdsByAcc(this.acc).subscribe(

      data => {
        for(let imgId of data){
          this.imgService.getImage(imgId).subscribe(

            data => {
              let reader = new FileReader();
              reader.addEventListener("load", () => {
                this.images.push(reader.result as string);
              }, false);
              reader.readAsDataURL(data);
            }
          )
        }
      }

    )

    this.pisService.getPriceInSeasonByAcc(this.acc.id).subscribe(

      data => {
        this.pricesInSeason = data;
        
      }
    )
    
      this.reservationService.getReservationsByAcc(this.acc.id).subscribe(
        data=>{
          this.reservations = data;
        }
      )


  }

  addPricePlanClick(){
    if(isNaN(this.newPriceInSeason.price ) || this.newPriceInSeason.price < 0){
      this.ppErrorMessage = "Fill price correctly!";
      setTimeout(() => {
        this.ppErrorMessage = "";
      }, 3000);
      return;
    } 

    this.newPriceInSeason.inMonth = this.selectedMonth;
    this.newPriceInSeason.currency = this.selectedCurrency;
    this.newPriceInSeason.accId = this.acc.id;
    
    this.pisService.addNewPriceInSeason(this.newPriceInSeason).subscribe(
      data => {

        this.pisService.getPriceInSeasonByAcc(this.acc.id).subscribe(
          data => {
            this.pricesInSeason = data;
          }
        )
        this.selectedMonth = Months.JANUARY;
        this.selectedCurrency = Currencies.EUR;
        this.newPriceInSeason = new PriceInSeason();
      }
    )

  }
  deletePriceInSeason(price){
    this.pisService.deletePriceInSeason(price.id);
  }
  
}
