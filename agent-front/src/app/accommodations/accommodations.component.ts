import { Component, OnInit } from '@angular/core';
import { AccommodationService } from '../services/accommodation.service';
import { HttpClient } from '@angular/common/http';
import { Accommodation } from '../model/accommodation.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-accommodations',
  templateUrl: './accommodations.component.html',
  styleUrls: ['./accommodations.component.css']
})
export class AccommodationsComponent implements OnInit {

  accommodations: Accommodation[];
  acc = new Accommodation();

  constructor(private accommodationService : AccommodationService,  
              private router : Router, 
              private route: ActivatedRoute) {}

  ngOnInit() {
    this.accommodationService.getThatIOwn().subscribe(
      data => { this.accommodations = data }
    )
  }

  delete(acc : Accommodation){
    this.accommodationService.delete(acc).subscribe(
      data => { this.accommodations = data }
    )
  }

  editAccClick(acc : Accommodation){
    this.accommodationService.setEditingAcc(acc);
    this.router.navigate(['editAccommodation'], {relativeTo : this.route});
  }

}
