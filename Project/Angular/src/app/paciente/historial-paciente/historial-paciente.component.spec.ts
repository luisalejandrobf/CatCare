import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistorialPacienteComponent } from './historial-paciente.component';

describe('HistorialPacienteComponent', () => {
  let component: HistorialPacienteComponent;
  let fixture: ComponentFixture<HistorialPacienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HistorialPacienteComponent]
    });
    fixture = TestBed.createComponent(HistorialPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
