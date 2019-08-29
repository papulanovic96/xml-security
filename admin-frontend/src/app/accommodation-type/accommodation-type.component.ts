import { Component, OnInit } from '@angular/core';
import { AccommodationTypeService } from './accommodation-type.service';
import { AccommodationType } from './accommodation-type';

@Component({
  selector: 'app-accommodation-type',
  templateUrl: './accommodation-type.component.html',
  styleUrls: ['./accommodation-type.component.css']
})
export class AccommodationTypeComponent implements OnInit {

  types: AccommodationType[] = [];
  type = new AccommodationType(0, '');

  constructor(private aTypeService: AccommodationTypeService) { }

  ngOnInit() {
    this.aTypeService.getTypes().subscribe(
      types => {
        this.types = types;
      }
    )
  }

  delete(name: string) {
    this.aTypeService.deleteType(name).subscribe(
      response => { this.types = response }
    );
  }

  onSubmit() {
    this.aTypeService.addType(this.type).subscribe(
      response => { this.types = response }
    );
  }
}
