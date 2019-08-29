import { Component, OnInit } from '@angular/core';
import { AccommodationType, UpdateAccommodationTypeRequest } from '../accommodation-type';
import { AccommodationTypeModifyService } from './accommodation-type-modify.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-accommodation-type-modify',
  templateUrl: './accommodation-type-modify.component.html',
  styleUrls: ['./accommodation-type-modify.component.css']
})
export class AccommodationTypeModifyComponent implements OnInit {

  pageTitle: string;
  someType: AccommodationType;
  
  update = new UpdateAccommodationTypeRequest;

  constructor(private aTypeService: AccommodationTypeModifyService, private route: ActivatedRoute, private router: Router)  {

   }

  ngOnInit() {
    const param = this.route.snapshot.paramMap.get('id');

    this.pageTitle = 'Modify type: ';
    if(param) {
      const id =+ param;
      this.getTypeID(id);
    }
  }

  getTypeID(id: number) {
    this.aTypeService.getTypeById(id).subscribe(
      someType => { this.someType = someType 
                    this.update.oldName = someType.name}
    );
  }

  apply() {
    this.update.newName = this.someType.name;
    console.log(this.update)
    this.aTypeService.updateType(this.update).subscribe();
    this.router.navigate(['accommodation-type']);
  }

  onBack(): void {
    this.router.navigate(['accommodation-type']);
  }
}
