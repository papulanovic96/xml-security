import { Component, OnInit, ViewChild } from '@angular/core';
import { AdditionalServicesService } from './additional-services.service'
import { AdditionalServices } from './additional-services';

@Component({
  selector: 'app-additional-services',
  templateUrl: './additional-services.component.html',
  styleUrls: ['./additional-services.component.css']
})
export class AdditionalServicesComponent implements OnInit {

  services: AdditionalServices[];
  service = new AdditionalServices(0, '');

  constructor(private serviceAdditional: AdditionalServicesService) { }

  ngOnInit() {
    this.serviceAdditional.getAdditionalServices().subscribe(
      services => this.services = services
    );
  }

  delete(name: string) {
    this.serviceAdditional.deleteService(name).subscribe( 
      data => { this.services = data }
    );
  }

  onSubmit() {
    this.serviceAdditional.addService(this.service).subscribe(
      data => { this.services = data }
    );
   }

}
