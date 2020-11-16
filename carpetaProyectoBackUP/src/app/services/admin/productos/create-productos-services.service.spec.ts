import { TestBed } from '@angular/core/testing';

import { CreateProductosServicesService } from './create-productos-services.service';

describe('CreateProductosServicesService', () => {
  let service: CreateProductosServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateProductosServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
