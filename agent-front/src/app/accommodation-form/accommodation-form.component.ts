import { Component, OnInit, ElementRef, Renderer2 } from '@angular/core';
import { Accommodation, CreateAccommodationRequest } from '../model/accommodation.model';
import { Address } from '../model/address.model';
import { AccommodationType } from '../model/AccommodationType.model';
import { AccommodationService } from '../services/accommodation.service';
import { ImageService } from '../services/image.service';
import { AdditionalService } from '../model/additionalservice.model';
import { PriceInSeason, PriceRequest } from '../model/priceInSeason.model';
import { Currencies } from '../model/currencies.enum';
import { Months } from '../model/months.enum';
import { Cancelation } from '../model/cancelation.model';
import { CodebookService } from '../services/codebook.service';
import { AccommodationCategory } from '../model/accommodationCategory.model';

@Component({
  selector: 'app-accommodation-form',
  templateUrl: './accommodation-form.component.html',
  styleUrls: ['./accommodation-form.component.css']
})
export class AccommodationFormComponent implements OnInit {

  request:CreateAccommodationRequest = new CreateAccommodationRequest();
  additionalServices: AdditionalService[];
  types: AccommodationType[];
  categories: AccommodationCategory[];

  type:AccommodationType = new AccommodationType();
  
  address:Address = new Address();
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
  constructor(private accService : AccommodationService, 
              private imgService: ImageService, 
              private _elementRef : ElementRef, 
              private renderer:Renderer2,
              private codebookService: CodebookService) {}
  
  ngOnInit() {
    this.codebookService.getAdditionalServices().subscribe(
      data => { this.additionalServices = data }
    )

    this.codebookService.getCategories().subscribe(
      data => this.categories = data
    )

    this.codebookService.getTypes().subscribe(
      data => this.types = data
    )

  }

  apply() {
    var price = new PriceRequest();

    price.currency = this.selectedCurrency;
    price.month = this.selectedMonth;
    price.price = this.priceInSeason.price;

    delete this.months[this.selectedMonth]

    this.request.pricelist.push(price);

    console.log(this.request.pricelist)

  }

  finish(){
    
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

    if (this.request.name == null) {     
      this.renderer.addClass(name, 'border-danger');
      errors++;
    } else {
      this.renderer.removeClass(name, 'border-danger');
    }

    if (this.selectedCategory == -1) {
      this.renderer.addClass(category, 'border-danger');
      errors++;
    } else {
      this.request.category = this.selectedCategory.toString();
      this.renderer.removeClass(category, 'border-danger');
    }

    if (this.selectedType.id == -1) {
      this.renderer.addClass(type, 'border-danger');
      errors++;
    } else {
      this.request.type = this.selectedType.name;
      this.renderer.removeClass(type, 'border-danger');
    }

    if (this.request.description == "") {
      this.renderer.addClass(description, 'border-danger');
      errors++;
    } else {
      this.renderer.removeClass(description, 'border-danger');
    }

    if (this.selectImagesMessage == "Select images") {
      errors++;
      this.errorMessage = "Select at least one image!";
      
      setInterval(()=>{
        this.errorMessage = "";
      }, 3000)
    }

    if (isNaN(this.request.capacity) || this.request.capacity<0) {
      this.renderer.addClass(accCapacity, 'border-danger');
      errors++;
    } else {
      this.renderer.removeClass(accCapacity, 'border-danger');
    }

    if (isNaN(this.cancelation.daysLeft) || this.cancelation.daysLeft<0){  
      this.renderer.addClass(cancelingPeriod, 'border-danger');
      errors++;
    } else {
      this.request.cancellation.available = true;
      this.request.cancellation.period = this.cancelation.daysLeft;
      this.renderer.removeClass(cancelingPeriod, 'border-danger');
    }

    //ADRESA
      
    // if (this.address.country == "") {
    //   this.renderer.addClass(country, 'border-danger');
    //   errors++;
    // } else {
    //     this.acc.address.country = this.address.country;
    //     this.renderer.removeClass(country, 'border-danger');
    // }
      
    if (this.address.city == "") {
      this.renderer.addClass(city, 'border-danger');
      errors++;
    } else {
      this.request.city = this.address.city;
      this.renderer.removeClass(city, 'border-danger');
    }

    // if (this.address.street == "") {
    //   this.renderer.addClass(street, 'border-danger');
    //   errors++;
    // } else {
    //   this.acc.address.street = this.address.street;
    //   this.renderer.removeClass(street, 'border-danger');
    // }

    if (isNaN(this.priceInSeason.price ) || this.priceInSeason.price < 0) {
      this.renderer.addClass(price, 'border-danger');
      errors++;
    } else {
        price = new PriceRequest();
        price.currency = this.selectedCurrency;
        price.month = this.selectedMonth;
        this.request.pricelist.push(price);
    }

    if (errors != 0 && this.errorMessage != "Select at least one image!") {
        this.errorMessage = "Fill required fields corectly!";
        setTimeout(()=> { this.errorMessage = ""}, 3000)
    }

    if (errors == 0) {
      for(let service of this.additionalServices){
        if (service.isChecked) {
          this.request.additionalServices.push(service.name);
        }
      }

      console.log(this.request)

      this.accService.create(this.request).subscribe()//show all accommodatios )
        //ciscenje forme
      this.selectedType  = {"id": -1, "name": "Accommodation type", "disabled": true};
      this.codebookService.getAdditionalServices().subscribe(
        data => this.additionalServices = data
      )

      this.codebookService.getTypes().subscribe(
        data => this.types = data
      )

      this.request = new CreateAccommodationRequest();
      this.selectImagesMessage = "Select images";
      this.address = new Address();
      this.priceInSeason = new PriceInSeason();
      this.selectedCategory = -1;
      this.cancelation = new Cancelation();
      this.selectedMonth = Months.JANUARY;

    } else {
        return;
    } 
  }

  onFilesSelected(event){
    this.selectedFiles = event.target.files;

    if (this.selectedFiles.length == 0) {
      this.selectImagesMessage = "Select images";
    } else {
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
