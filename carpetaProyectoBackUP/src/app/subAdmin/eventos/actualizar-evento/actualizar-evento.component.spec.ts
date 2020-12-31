import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarEventoComponent } from './actualizar-evento.component';

describe('ActualizarEventoComponent', () => {
  let component: ActualizarEventoComponent;
  let fixture: ComponentFixture<ActualizarEventoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualizarEventoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarEventoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
