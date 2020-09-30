import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IniSesionProductComponent } from './ini-sesion-product.component';

describe('IniSesionProductComponent', () => {
  let component: IniSesionProductComponent;
  let fixture: ComponentFixture<IniSesionProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IniSesionProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IniSesionProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
