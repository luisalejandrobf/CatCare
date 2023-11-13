import { TestBed } from '@angular/core/testing';

// Correct the import to match the exported service name
import { LandbotService } from './landbot-service.service';

describe('LandbotService', () => {
  let service: LandbotService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LandbotService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
