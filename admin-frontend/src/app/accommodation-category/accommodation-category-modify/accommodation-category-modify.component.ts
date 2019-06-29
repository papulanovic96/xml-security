import { Component, OnInit } from '@angular/core';
import { AccommodationCategory } from '../accommodation-category';
import { AccommodationCategoryModifyService } from './accommodation-category-modify.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-accommodation-category-modify',
  templateUrl: './accommodation-category-modify.component.html',
  styleUrls: ['./accommodation-category-modify.component.css']
})
export class AccommodationCategoryModifyComponent implements OnInit {

  pageTitle: string;
  someCategory: AccommodationCategory;

  constructor(private aCategoryService: AccommodationCategoryModifyService, private route: ActivatedRoute, private router: Router)  {

   }

  ngOnInit() {
    const param = this.route.snapshot.paramMap.get('id');

    this.pageTitle = 'Modify category: ';
    if(param) {
      const id =+ param;
      this.getCategoryID(id);
    }
  }

  getCategoryID(id: number) {
    this.aCategoryService.getCategoryID(id).subscribe(
      someCategory => this.someCategory = someCategory
    );
  }

  onModify(id: number) {
    this.aCategoryService.updateCategory(id, this.someCategory).subscribe();
    this.router.navigate(['accommodation-category']);
  }

  onBack(): void {
    this.router.navigate(['accommodation-category']);
  }

}
