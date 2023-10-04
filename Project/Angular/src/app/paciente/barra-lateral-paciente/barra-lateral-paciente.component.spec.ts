import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraLateralPacienteComponent } from './barra-lateral-paciente.component';

describe('BarraLateralPacienteComponent', () => {
  let component: BarraLateralPacienteComponent;
  let fixture: ComponentFixture<BarraLateralPacienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarraLateralPacienteComponent]
    });
    fixture = TestBed.createComponent(BarraLateralPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
