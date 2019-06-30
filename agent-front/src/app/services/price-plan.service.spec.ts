import { TestBed } from '@angular/core/testing';

import { PriceInSeasonService } from './price-in-season.service';

describe('PricePlanService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PriceInSeasonService = TestBed.get(PriceInSeasonService);
    expect(service).toBeTruthy();
  });
});
