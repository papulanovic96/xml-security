import { Component, OnInit } from '@angular/core';
import { AccommodationCategory } from './accommodation-category';
import { AccommodationCategoryService } from './accommodation-category.service';

@Component({
  selector: 'app-accommodation-category',
  templateUrl: './accommodation-category.component.html',
  styleUrls: ['./accommodation-category.component.css']
})
export class AccommodationCategoryComponent implements OnInit {

  categories: AccommodationCategory[] = [];
  category = new AccommodationCategory(0, '');

  constructor(private aCategoryService: AccommodationCategoryService) { }

  
  ngOnInit() {
    this.aCategoryService.getCategories().subscribe(
      categories => {
        this.categories = categories;
      }
    )
  }

  delete(id: number) {
    this.aCategoryService.deleteCategory(id).subscribe();
    window.location.reload();
  }

  onSubmit() {
    this.aCategoryService.addCategory(this.category).subscribe(
      category => this.categories.push(category)
    );
    window.location.reload();
  }

}
