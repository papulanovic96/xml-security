import { Component, OnInit } from '@angular/core';
import { AccommodationCategory, DeleteAccommodationCategoryRequest, CreateAccommodationCategoryRequest } from './accommodation-category';
import { AccommodationCategoryService } from './accommodation-category.service';

@Component({
  selector: 'app-accommodation-category',
  templateUrl: './accommodation-category.component.html',
  styleUrls: ['./accommodation-category.component.css']
})
export class AccommodationCategoryComponent implements OnInit {

  categories: AccommodationCategory[] = [];
  category = new AccommodationCategory(0, '');

  deleteCat: DeleteAccommodationCategoryRequest;
  createCat: CreateAccommodationCategoryRequest;

  constructor(private aCategoryService: AccommodationCategoryService) { }

  
  ngOnInit() {
    this.aCategoryService.getCategories().subscribe(
      categories => {
        this.categories = categories;
      }
    )
  }

  delete(name: string) {
    this.aCategoryService.deleteCategory(name).subscribe(
      response => {this.categories = response;}
    );
   
  }

  onSubmit() {
    this.aCategoryService.createCategory(this.category.name).subscribe(
      response => {this.categories = response}
    );
  }

  selected(cat: string) : string {
    return cat;
  }

}
