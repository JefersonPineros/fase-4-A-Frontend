import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { GestorPedidoComponent } from './gestor-pedido.component';

describe('GestorPedidoComponent', () => {
  let component: GestorPedidoComponent;
  let fixture: ComponentFixture<GestorPedidoComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ GestorPedidoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestorPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
