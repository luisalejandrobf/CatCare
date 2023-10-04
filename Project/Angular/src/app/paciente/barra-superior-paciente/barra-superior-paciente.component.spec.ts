import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraSuperiorPacienteComponent } from './barra-superior-paciente.component';

describe('BarraSuperiorPacienteComponent', () => {
  let component: BarraSuperiorPacienteComponent;
  let fixture: ComponentFixture<BarraSuperiorPacienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarraSuperiorPacienteComponent]
    });
    fixture = TestBed.createComponent(BarraSuperiorPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
