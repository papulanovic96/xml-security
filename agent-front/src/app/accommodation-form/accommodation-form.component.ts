import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/accommodation.model';
import { Address } from '../model/address.model';
import { HttpClient } from '@angular/common/http';
import { AccommodationType } from '../model/AccommodationType.model';
import { AccommodationService } from '../services/accommodation.service';
import { PictureService } from '../services/picture.service';
import { AdditionalService } from '../model/additionalservice.model';

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

  constructor(private http : HttpClient, private accService : AccommodationService, 
    private picService: PictureService) { 

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
    
    this.acc.address = new Address();
    this.acc.address = this.address;

    


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

    uploadPictures(accId){
      let fd = new FormData();
      for ( let file of this.selectedFiles){
        fd.append('file', file);
      }
      fd.append('accId', accId);
      this.picService.uploadPictures(fd);
  }



}
