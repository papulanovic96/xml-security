import { Component, OnInit } from '@angular/core';
import { AccommodationCategory, DeleteAccommodationCategoryRequest, CreateAccommodationCategoryRequest } from './accommodation-category';
import { AccommodationCategoryService } from './accommodation-category.service';
import { TokenStorageService } from '../auth/token-storage.service';

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

  isAdmin: boolean;

  constructor(private aCategoryService: AccommodationCategoryService,
              private tokenStorage: TokenStorageService) { }

  
  ngOnInit() {
    this.aCategoryService.getCategories().subscribe(
      categories => {
        this.categories = categories;
      }
    )

    if (this.tokenStorage.getAuthorities().includes('ROLE_ADMIN'))
      this.isAdmin = true;
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
