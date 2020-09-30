import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroProComponent } from './registro-pro.component';

describe('RegistroProComponent', () => {
  let component: RegistroProComponent;
  let fixture: ComponentFixture<RegistroProComponent>;

  beforeEach(async(() => {
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
