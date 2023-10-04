import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeterinarioComponent } from './veterinario.component';

describe('VeterinarioComponent', () => {
  let component: VeterinarioComponent;
  let fixture: ComponentFixture<VeterinarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VeterinarioComponent]
    });
    fixture = TestBed.createComponent(VeterinarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
