import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificarPacienteComponent } from './modificar-paciente.component';

describe('ModificarPacienteComponent', () => {
  let component: ModificarPacienteComponent;
  let fixture: ComponentFixture<ModificarPacienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModificarPacienteComponent]
    });
    fixture = TestBed.createComponent(ModificarPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
