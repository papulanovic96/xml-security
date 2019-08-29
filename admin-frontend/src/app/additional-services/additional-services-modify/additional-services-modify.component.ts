import { Component, OnInit } from '@angular/core';
import { AdditionalServices } from '../additional-services';
import { AdditionalServicesModifyService } from './additional-services-modify.service';
import { UpdateAdditionalServiceRequest } from '../additional-services';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-additional-services-modify',
  templateUrl: './additional-services-modify.component.html',
  styleUrls: ['./additional-services-modify.component.css']
})
export class AdditionalServicesModifyComponent implements OnInit {

  pageTitle: string;
  aService: AdditionalServices;

  update = new UpdateAdditionalServiceRequest;

  constructor(private aServiceService: AdditionalServicesModifyService, 
              private route: ActivatedRoute, 
              private router: Router) { }

  ngOnInit() {
    const param = this.route.snapshot.paramMap.get('id');

    this.pageTitle = 'Modify service: ';
    if(param) {
      const id =+ param;
      this.getAdditionalServiceId(id);
    }
  }

  getAdditionalServiceId(id: number) {
    this.aServiceService.getOneService(id).subscribe(
      aService => { this.aService = aService; 
                    this.update.oldName = this.aService.name
                    this.pageTitle += this.aService.name }
    );
  }

  onModify() {
    this.update.newName = this.aService.name
    console.log(this.update)
    this.aServiceService.updateService(this.update).subscribe();
    this.router.navigate(['additional-services']);
  }

  onBack(): void {
    this.router.navigate(['additional-services']);
  }
}
