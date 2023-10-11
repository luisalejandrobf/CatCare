import { TestBed } from '@angular/core/testing';

import { VeterinarioService } from './veterinario.service';

describe('VeterinarioService', () => {
  let service: VeterinarioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VeterinarioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
