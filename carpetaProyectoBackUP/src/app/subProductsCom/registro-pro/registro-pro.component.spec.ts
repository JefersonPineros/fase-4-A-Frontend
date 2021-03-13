import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { RegistroProComponent } from './registro-pro.component';

describe('RegistroProComponent', () => {
  let component: RegistroProComponent;
  let fixture: ComponentFixture<RegistroProComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistroProComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistroProComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
