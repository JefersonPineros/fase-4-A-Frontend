import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcesarCancionesComponent } from './procesar-canciones.component';

describe('ProcesarCancionesComponent', () => {
  let component: ProcesarCancionesComponent;
  let fixture: ComponentFixture<ProcesarCancionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcesarCancionesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcesarCancionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
