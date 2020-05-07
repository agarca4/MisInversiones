import { TestBed } from '@angular/core/testing';

import { CarterasApiService } from './carteras-api.service';

describe('CarterasApiService', () => {
  let service: CarterasApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarterasApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
