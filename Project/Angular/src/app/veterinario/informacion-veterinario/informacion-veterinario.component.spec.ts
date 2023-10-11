import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InformacionVeterinarioComponent } from './informacion-veterinario.component';

describe('InformacionVeterinarioComponent', () => {
  let component: InformacionVeterinarioComponent;
  let fixture: ComponentFixture<InformacionVeterinarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InformacionVeterinarioComponent]
    });
    fixture = TestBed.createComponent(InformacionVeterinarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
