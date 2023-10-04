import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaPacienteComponent } from './tabla-paciente.component';

describe('TablaPacienteComponent', () => {
  let component: TablaPacienteComponent;
  let fixture: ComponentFixture<TablaPacienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaPacienteComponent]
    });
    fixture = TestBed.createComponent(TablaPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
