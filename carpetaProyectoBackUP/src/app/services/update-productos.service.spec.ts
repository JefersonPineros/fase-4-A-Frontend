import { TestBed } from '@angular/core/testing';

import { UpdateProductosService } from './update-productos.service';

describe('UpdateProductosService', () => {
  let service: UpdateProductosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateProductosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
