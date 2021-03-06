import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { EliminarUsuarioComponent } from './eliminar-usuario.component';

describe('EliminarUsuarioComponent', () => {
  let component: EliminarUsuarioComponent;
  let fixture: ComponentFixture<EliminarUsuarioComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ EliminarUsuarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EliminarUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
