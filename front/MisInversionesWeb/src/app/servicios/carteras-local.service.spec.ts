import { TestBed } from '@angular/core/testing';

import { CarterasLocalService } from './carteras-local.service';

describe('CarterasLocalService', () => {
  let service: CarterasLocalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarterasLocalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
