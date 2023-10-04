import {Component, EventEmitter, Output} from '@angular/core';
import {Paciente} from '../paciente';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-formulario-registro-paciente',
  templateUrl: './formulario-registro-paciente.component.html',
  styleUrls: ['./formulario-registro-paciente.component.css']
})
export class FormularioRegistroPacienteComponent {
  @Output() pacienteRegistrado = new EventEmitter<Paciente>();
  paciente: Paciente = {
    nombre: '',
    raza: '',
    edad: '',
    peso: '',
    estado: '',
    foto: '',
    clienteNombre: '',
  };

  onSubmit(form: any) {
    if (form.valid) {
      this.pacienteRegistrado.emit(this.paciente);
      console.log('Evento pacienteRegistrado emitido:', this.paciente); // Añade este log
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }
}
