import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { UpdateUsuarioComponent } from './update-usuario.component';

describe('UpdateUsuarioComponent', () => {
  let component: UpdateUsuarioComponent;
  let fixture: ComponentFixture<UpdateUsuarioComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateUsuarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
