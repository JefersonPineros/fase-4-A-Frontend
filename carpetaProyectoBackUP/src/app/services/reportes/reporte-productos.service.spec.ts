import { TestBed } from '@angular/core/testing';

import { ReporteProductosService } from './reporte-productos.service';

describe('ReporteProductosService', () => {
  let service: ReporteProductosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReporteProductosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
