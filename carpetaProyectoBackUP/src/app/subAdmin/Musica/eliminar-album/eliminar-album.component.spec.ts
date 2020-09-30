import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EliminarAlbumComponent } from './eliminar-album.component';

describe('EliminarAlbumComponent', () => {
  let component: EliminarAlbumComponent;
  let fixture: ComponentFixture<EliminarAlbumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EliminarAlbumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EliminarAlbumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
