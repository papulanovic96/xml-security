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

  constructor(private http : HttpClient, private accService : AccommodationService,  private router : Router, private route: ActivatedRoute) { 

    this.accService.getAllAccommodations().subscribe(
      data => {
              this.accommodations = data;
             
      }
    )

  }

  ngOnInit() {
  }


  deleteAccClick(acc : Accommodation){
    this.accService.deleteAcc(acc).subscribe(

      success => {
        this.accService.getAllAccommodations().subscribe(
          data => {
                  this.accommodations = data;
                 
          })
      }

    )
  }

  editAccClick(acc : Accommodation){
    this.accService.setEditingAcc(acc);
    this.router.navigate(['editAccommodation'], {relativeTo : this.route});
  }

}
