import {Component, EventEmitter, Output} from '@angular/core';
import {Paciente} from "../paciente";
import {Cliente} from "../../cliente/cliente";

@Component({
  selector: 'app-registrar-paciente',
  templateUrl: './registrar-paciente.component.html',
  styleUrls: ['./registrar-paciente.component.css']
})
export class RegistrarPacienteComponent {

  @Output() pacienteRegistrado = new EventEmitter<Paciente>();


  paciente: Paciente = {
    id: 0,
    nombre: '',
    raza: '',
    edad: '',
    peso: '',
    estado: '',
    foto: '',
    cliente: {
      id: 0,
      cedula: '',
      nombre: '',
      correo: '',
      celular: '',
      foto: ''
    }
  };

  onSubmit(form: any) {
    if (form.valid) {
      this.pacienteRegistrado.emit(this.paciente);
      console.log('Evento pacienteRegistrado emitido:', this.paciente);
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }

}
