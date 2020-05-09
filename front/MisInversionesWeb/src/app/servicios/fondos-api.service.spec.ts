import { TestBed } from '@angular/core/testing';

import { FondosApiService } from './fondos-api.service';

describe('FondosApiService', () => {
  let service: FondosApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FondosApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
