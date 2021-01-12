import { TestBed } from '@angular/core/testing';

import { NetWorthService } from './net-worth.service';

describe('NetWorthService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NetWorthService = TestBed.get(NetWorthService);
    expect(service).toBeTruthy();
  });
});
