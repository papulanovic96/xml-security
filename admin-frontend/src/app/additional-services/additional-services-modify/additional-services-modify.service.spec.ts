import { TestBed } from '@angular/core/testing';

import { AdditionalServicesModifyService } from './additional-services-modify.service';

describe('AdditionalServicesModifyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdditionalServicesModifyService = TestBed.get(AdditionalServicesModifyService);
    expect(service).toBeTruthy();
  });
});
