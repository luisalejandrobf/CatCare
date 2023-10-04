import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-barra-lateral-paciente',
  templateUrl: './barra-lateral-paciente.component.html',
  styleUrls: ['./barra-lateral-paciente.component.css']
})
export class BarraLateralPacienteComponent {
  @Output() registrarPaciente = new EventEmitter<void>();

  registrarNuevoPaciente() {
    this.registrarPaciente.emit();
  }
}
