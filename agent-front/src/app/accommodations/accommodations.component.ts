import { Component, OnInit } from '@angular/core';
import { AccommodationService } from '../services/accommodation.service';
import { Accommodation } from '../model/accommodation.model';
import { Router, ActivatedRoute } from '@angular/router';
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-accommodations',
  templateUrl: './accommodations.component.html',
  styleUrls: ['./accommodations.component.css']
})
export class AccommodationsComponent implements OnInit {

  accommodations: Accommodation[];
  acc = new Accommodation();
  
  isLoggedIn: boolean;
  isAgent: boolean;

  constructor(private accommodationService : AccommodationService,  
              private router : Router, 
              private route: ActivatedRoute,
              private tokenStorage : TokenStorageService) {}

  ngOnInit() {
    if (this.tokenStorage.getToken() != null) { 
      this.isLoggedIn = true;

      if (this.tokenStorage.getAuthorities().includes('ROLE_AGENT'))
        this.isAgent = true;
    }

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
