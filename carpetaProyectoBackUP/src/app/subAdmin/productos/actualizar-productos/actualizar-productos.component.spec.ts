import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ActualizarProductosComponent } from './actualizar-productos.component';

describe('ActualizarProductosComponent', () => {
  let component: ActualizarProductosComponent;
  let fixture: ComponentFixture<ActualizarProductosComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualizarProductosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarProductosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
