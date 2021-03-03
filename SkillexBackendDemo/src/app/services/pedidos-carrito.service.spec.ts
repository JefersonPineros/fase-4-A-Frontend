import { TestBed } from '@angular/core/testing';

import { PedidosCarritoService } from './pedidos-carrito.service';

describe('PedidosCarritoService', () => {
  let service: PedidosCarritoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PedidosCarritoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
