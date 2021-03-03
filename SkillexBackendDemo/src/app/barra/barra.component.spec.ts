import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { BarraComponent } from './barra.component';

describe('BarraComponent', () => {
  let component: BarraComponent;
  let fixture: ComponentFixture<BarraComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ BarraComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BarraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
