import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CalendarioEventComponent } from './calendario-event.component';

describe('CalendarioEventComponent', () => {
  let component: CalendarioEventComponent;
  let fixture: ComponentFixture<CalendarioEventComponent>;

  beforeEach(waitForAsync(() => {
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
