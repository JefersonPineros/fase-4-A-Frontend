import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EliminarProductosComponent } from './eliminar-productos.component';

describe('EliminarProductosComponent', () => {
  let component: EliminarProductosComponent;
  let fixture: ComponentFixture<EliminarProductosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EliminarProductosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EliminarProductosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
