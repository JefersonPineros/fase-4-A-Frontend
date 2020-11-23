import { TestBed } from '@angular/core/testing';

import { PedidosServicesService } from './pedidos-services.service';

describe('PedidosServicesService', () => {
  let service: PedidosServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PedidosServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
