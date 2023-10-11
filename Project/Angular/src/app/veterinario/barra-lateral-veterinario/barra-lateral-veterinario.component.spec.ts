import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraLateralVeterinarioComponent } from './barra-lateral-veterinario.component';

describe('BarraLateralVeterinarioComponent', () => {
  let component: BarraLateralVeterinarioComponent;
  let fixture: ComponentFixture<BarraLateralVeterinarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarraLateralVeterinarioComponent]
    });
    fixture = TestBed.createComponent(BarraLateralVeterinarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
