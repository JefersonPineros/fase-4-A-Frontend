import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { GestorEventosComponent } from './gestor-eventos.component';

describe('GestorEventosComponent', () => {
  let component: GestorEventosComponent;
  let fixture: ComponentFixture<GestorEventosComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ GestorEventosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestorEventosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
