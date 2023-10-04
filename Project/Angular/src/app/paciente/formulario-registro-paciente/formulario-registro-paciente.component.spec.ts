import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioRegistroPacienteComponent } from './formulario-registro-paciente.component';

describe('FormularioRegistroPacienteComponent', () => {
  let component: FormularioRegistroPacienteComponent;
  let fixture: ComponentFixture<FormularioRegistroPacienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormularioRegistroPacienteComponent]
    });
    fixture = TestBed.createComponent(FormularioRegistroPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
