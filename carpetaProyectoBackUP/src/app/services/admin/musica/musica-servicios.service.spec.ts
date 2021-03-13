import { TestBed } from '@angular/core/testing';

import { MusicaServiciosService } from './musica-servicios.service';

describe('MusicaServiciosService', () => {
  let service: MusicaServiciosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MusicaServiciosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
