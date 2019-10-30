import { TestBed, inject } from '@angular/core/testing';

import { BirdService } from './bird.service';

describe('BirdService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BirdService]
    });
  });

  it('should be created', inject([BirdService], (service: BirdService) => {
    expect(service).toBeTruthy();
  }));
});
