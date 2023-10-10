import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaPacienteClienteComponent } from './tabla-paciente-cliente.component';

describe('TablaPacienteClienteComponent', () => {
  let component: TablaPacienteClienteComponent;
  let fixture: ComponentFixture<TablaPacienteClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaPacienteClienteComponent]
    });
    fixture = TestBed.createComponent(TablaPacienteClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
