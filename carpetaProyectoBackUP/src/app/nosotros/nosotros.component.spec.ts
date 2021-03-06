import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { NosotrosComponent } from './nosotros.component';

describe('NosotrosComponent', () => {
  let component: NosotrosComponent;
  let fixture: ComponentFixture<NosotrosComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ NosotrosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NosotrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
