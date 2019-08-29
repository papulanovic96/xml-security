import { Component, OnInit, Input } from '@angular/core';
import { AccommodationCategory, UpdateAccommodationCategoryRequest } from '../accommodation-category';
import { AccommodationCategoryService } from '../accommodation-category.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-accommodation-category-modify',
  templateUrl: './accommodation-category-modify.component.html',
  styleUrls: ['./accommodation-category-modify.component.css']
})
export class AccommodationCategoryModifyComponent implements OnInit {

  @Input() childMessage;

  pageTitle: string;
  someCategory: AccommodationCategory;

  update = new UpdateAccommodationCategoryRequest();

  constructor(private aCategoryService: AccommodationCategoryService, private route: ActivatedRoute, private router: Router)  {

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
    this.aCategoryService.getCategory(id).subscribe(
      someCategory => { this.someCategory = someCategory 
                        this.update.oldName = someCategory.name
                        this.pageTitle += someCategory.name}
    );
  }

  apply() {
    console.log(this.update)
    this.update.newName = this.someCategory.name;
    this.aCategoryService.updateCategory(this.update).subscribe();
  }

}
