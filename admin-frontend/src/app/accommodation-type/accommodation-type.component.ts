import { Component, OnInit } from '@angular/core';
import { AccommodationTypeService } from './accommodation-type.service';
import { AccommodationType } from './accommodation-type';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-accommodation-type',
  templateUrl: './accommodation-type.component.html',
  styleUrls: ['./accommodation-type.component.css']
})
export class AccommodationTypeComponent implements OnInit {

  types: AccommodationType[] = [];
  type = new AccommodationType(0, '');
  isAdmin: boolean;

  constructor(private aTypeService: AccommodationTypeService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.aTypeService.getTypes().subscribe(
      types => {
        this.types = types;
      }
    )

    if (this.tokenStorage.getAuthorities().includes('ROLE_ADMIN'))
      this.isAdmin = true;
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
