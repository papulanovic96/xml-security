import { Component, OnInit, ElementRef, Renderer2 } from '@angular/core';
import { Accommodation } from '../model/accommodation.model';
import { Address } from '../model/address.model';
import { HttpClient } from '@angular/common/http';
import { AccommodationType } from '../model/AccommodationType.model';
import { AccommodationService } from '../services/accommodation.service';
import { ImageService } from '../services/image.service';
import { AdditionalService } from '../model/additionalservice.model';
import { PriceInSeason } from '../model/priceInSeason.model';
import { Currencies } from '../model/currencies.enum';
import { Months } from '../model/months.enum';
import { Cancelation } from '../model/cancelation.model';


@Component({
  selector: 'app-accommodation-form',
  templateUrl: './accommodation-form.component.html',
  styleUrls: ['./accommodation-form.component.css']
})
export class AccommodationFormComponent implements OnInit {

  acc:Accommodation = new Accommodation();
  address:Address = new Address();
  type:AccommodationType = new AccommodationType();
  accServices: AdditionalService[];
  accTypes: AccommodationType[];
  selectedType : AccommodationType = {"id": -1, "name": "Accommodation type", "disabled": true};
  selectedCategory : number = -1;
  selectImagesMessage = "Select images";
  selectedFiles : any[];
  
  currencies= Currencies;
  selectedCurrency = Currencies.EUR;
  months= Months;
  selectedMonth = Months.JANUARY;
  priceInSeason: PriceInSeason = new PriceInSeason();
  errorMessage="";
  cancelation = new Cancelation();

  keysCurrencies():Array<string>{
    var keys = Object.keys(this.currencies);
    return keys;
  }  
  keysMonths():Array<string>{
    var keys = Object.keys(this.months);
    return  keys;
  } 
  constructor(private http : HttpClient, private accService : AccommodationService, 
    private imgService: ImageService, private _elementRef : ElementRef, private renderer:Renderer2) { 

    accService.getAllAccomodationTypes().subscribe(
      data => {
              this.accTypes = data;
              this.accTypes.push(this.selectedType);
      }
    )
    accService.getAllAccServices().subscribe(
      data => {
              
        this.accServices = data;

      }
    )
  }
  ngOnInit() {
   
  }

  addAccommodationClick(){
    
   
    
    let errors:number = 0;
    let name = this._elementRef.nativeElement.querySelector('#name');
    let category = this._elementRef.nativeElement.querySelector('#category');
    let type = this._elementRef.nativeElement.querySelector('#type');
    let description = this._elementRef.nativeElement.querySelector('#description');
    let cancelingPeriod = this._elementRef.nativeElement.querySelector('#cancelingPeriod');
    let accCapacity = this._elementRef.nativeElement.querySelector('#capacity');
    let long = this._elementRef.nativeElement.querySelector('#longitude');
    let lat = this._elementRef.nativeElement.querySelector('#latitude');
    let price = this._elementRef.nativeElement.querySelector('#price');
    let country = this._elementRef.nativeElement.querySelector('#country');
    let city = this._elementRef.nativeElement.querySelector('#city');
    let postcode = this._elementRef.nativeElement.querySelector('#postcode');
    let street = this._elementRef.nativeElement.querySelector('#street');



    if(this.acc.name == null){
     
      this.renderer.addClass(name, 'border-danger');
      errors++;
    }else
    {
      this.renderer.removeClass(name, 'border-danger');
    }


    if(this.selectedCategory == -1){
      this.renderer.addClass(category, 'border-danger');
      errors++;
    }else
    {
      this.acc.category.name = this.selectedCategory.toString();
      this.renderer.removeClass(category, 'border-danger');
    }

    if(this.selectedType.id == -1){
      this.renderer.addClass(type, 'border-danger');
      errors++;
    }else
    {
      this.acc.type = this.selectedType;
      this.renderer.removeClass(type, 'border-danger');
    }

    if(this.acc.description == ""){
      this.renderer.addClass(description, 'border-danger');
      errors++;
    }else
    {
      this.renderer.removeClass(description, 'border-danger');
    }

    
    if(this.selectImagesMessage == "Select images"){
      errors++;
      this.errorMessage = "Select at least one image!";
      setInterval(()=>{
      this.errorMessage = "";
    },
    3000)
  }

  if(isNaN(this.acc.capacity) || this.acc.capacity<0){
      
    this.renderer.addClass(accCapacity, 'border-danger');
    errors++;
  }else{
    
    this.renderer.removeClass(accCapacity, 'border-danger');

  }


    if(isNaN(this.cancelation.daysLeft) || this.cancelation.daysLeft<0){
    
      this.renderer.addClass(cancelingPeriod, 'border-danger');
      errors++;
     }else{
      this.acc.cancelation.daysLeft = this.cancelation.daysLeft;
      this.renderer.removeClass(cancelingPeriod, 'border-danger');

      }

//ADRESA
      
      if(this.address.country == ""){
        this.renderer.addClass(country, 'border-danger');
        errors++;
      }else{
        this.acc.address.country = this.address.country;
        this.renderer.removeClass(country, 'border-danger');
      }
      
      if(this.address.city == ""){
        this.renderer.addClass(city, 'border-danger');
        errors++;
      }else{
        this.acc.address.city = this.address.city;
        this.renderer.removeClass(city, 'border-danger');
      }

      if(isNaN(this.address.zip) || this.address.zip < 0){
        this.renderer.addClass(postcode, 'border-danger');
        errors++;
      }else{
        this.acc.address.zip = this.address.zip;
        this.renderer.removeClass(postcode, 'border-danger');
      }

      if(this.address.street == ""){
        this.renderer.addClass(street, 'border-danger');
        errors++;
      }else{
        this.acc.address.street = this.address.street;
        this.renderer.removeClass(street, 'border-danger');
      }


      if(isNaN(this.address.longitude)){
       
        this.renderer.addClass(long, 'border-danger');
        errors++;
      }else{
        this.acc.address.longitude = this.address.longitude;
        this.renderer.removeClass(lat, 'border-danger');
      }

      if(isNaN(this.address.latitude)){
       
        this.renderer.addClass(lat, 'border-danger');
        errors++;
      }else{
        this.acc.address.latitude = this.address.latitude;
        this.renderer.removeClass(lat, 'border-danger');
      }

      if(isNaN(this.priceInSeason.price ) || this.priceInSeason.price < 0){
        this.renderer.addClass(price, 'border-danger');
        errors++;
      }else{
        
        this.priceInSeason.currency = this.selectedCurrency;
        this.priceInSeason.inMonth = this.selectedMonth;
        this.acc.priceInSeason.push(this.priceInSeason);
        this.renderer.removeClass(price, 'border-danger');
      }


      if(errors != 0 && this.errorMessage != "Select at least one image!"){
        this.errorMessage = "Fill required fields corectly!";
        setTimeout(()=>{
          this.errorMessage = "";
        },
        3000)
      }
      if(errors == 0){
        for(let service of this.accServices){
          if(service.isChecked){
            this.acc.additionalService.push(service);
          }
        }

        this.accService.addNewAccommodation(this.acc).subscribe(

          data => {
            
            this.uploadImages(data.id);
            this.accService.getAllAccommodations().subscribe(
             data => {
              this.accService.setCurrentAccommodations(data);
             }
            )
          }
          
        )
        //ciscenje forme
        this.selectedType  = {"id": -1, "name": "Accomodation type", "disabled" : true};
        this.accService.getAllAccServices().subscribe(
          data =>{
            this.accServices = data;
          }
        )
        this.accService.getAllAccomodationTypes().subscribe(
          data =>{
            this.accTypes = data;
            this.accTypes.push(this.selectedType);
          }
        )

        this.acc = new Accommodation();
        this.selectImagesMessage = "Select images";
        this.address = new Address();
        this.priceInSeason = new PriceInSeason();
        this.selectedCategory = -1;
        this.cancelation = new Cancelation();
        this.selectedMonth = Months.JANUARY;

      } else{
          return;
      } 

}

  onFilesSelected(event){
    this.selectedFiles = event.target.files;
   
    if(this.selectedFiles.length == 0){
      this.selectImagesMessage = "Select images";
    }else{
      this.selectImagesMessage = "";
    
      for(let file of this.selectedFiles){
        this.selectImagesMessage = this.selectImagesMessage + file.name +", ";
      }
    }
    
  }

    uploadImages(accId){
      let fd = new FormData();
      for ( let file of this.selectedFiles){
        fd.append('file', file);
      }
      fd.append('accId', accId);
     this.imgService.uploadImages(fd);
  }



}
