import { TestBed } from '@angular/core/testing';

import { SendCorreoServiceService } from './send-correo-service.service';

describe('SendCorreoServiceService', () => {
  let service: SendCorreoServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SendCorreoServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
