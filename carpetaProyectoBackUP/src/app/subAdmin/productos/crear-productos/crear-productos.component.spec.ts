import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CrearProductosComponent } from './crear-productos.component';

describe('CrearProductosComponent', () => {
  let component: CrearProductosComponent;
  let fixture: ComponentFixture<CrearProductosComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearProductosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearProductosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
