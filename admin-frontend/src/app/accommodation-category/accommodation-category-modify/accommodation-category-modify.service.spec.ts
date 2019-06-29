import { TestBed } from '@angular/core/testing';

import { AccommodationCategoryModifyService } from './accommodation-category-modify.service';

describe('AccommodationCategoryModifyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AccommodationCategoryModifyService = TestBed.get(AccommodationCategoryModifyService);
    expect(service).toBeTruthy();
  });
});
