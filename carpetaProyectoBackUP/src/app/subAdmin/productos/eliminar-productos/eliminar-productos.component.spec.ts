import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { EliminarProductosComponent } from './eliminar-productos.component';

describe('EliminarProductosComponent', () => {
  let component: EliminarProductosComponent;
  let fixture: ComponentFixture<EliminarProductosComponent>;

  beforeEach(waitForAsync(() => {
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
