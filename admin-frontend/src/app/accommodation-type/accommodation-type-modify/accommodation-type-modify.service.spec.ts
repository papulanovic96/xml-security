import { TestBed } from '@angular/core/testing';

import { AccommodationTypeModifyService } from './accommodation-type-modify.service';

describe('AccommodationTypeModifyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AccommodationTypeModifyService = TestBed.get(AccommodationTypeModifyService);
    expect(service).toBeTruthy();
  });
});
