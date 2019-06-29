import { Component, OnInit } from '@angular/core';
import { AccommodationType } from '../accommodation-type';
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
      someType => this.someType = someType
    );
  }

  onModify(id: number) {
    this.aTypeService.updateType(id, this.someType).subscribe();
    this.router.navigate(['accommodation-type']);
  }

  onBack(): void {
    this.router.navigate(['accommodation-type']);
  }
}
