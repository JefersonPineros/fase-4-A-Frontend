import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarioEventComponent } from './calendario-event.component';

describe('CalendarioEventComponent', () => {
  let component: CalendarioEventComponent;
  let fixture: ComponentFixture<CalendarioEventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalendarioEventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalendarioEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
