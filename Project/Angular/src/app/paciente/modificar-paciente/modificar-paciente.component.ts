import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Paciente} from "../paciente";

@Component({
  selector: 'app-modificar-paciente',
  templateUrl: './modificar-paciente.component.html',
  styleUrls: ['./modificar-paciente.component.css']
})
export class ModificarPacienteComponent {

  @Input() paciente: Paciente | null = null;
  @Output() pacienteModificado = new EventEmitter<Paciente>();

  enviarFormulario() {
    if (this.paciente) {
      this.pacienteModificado.emit(this.paciente);
    }
  }

}
