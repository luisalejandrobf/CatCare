import { Component, EventEmitter, Output } from '@angular/core';
import { Paciente } from "../paciente";
import { Cliente } from "../../cliente/cliente";
import { Router } from "@angular/router";
import {PacienteService} from "../../service/paciente/paciente.service";

@Component({
  selector: 'app-registrar-paciente',
  templateUrl: './registrar-paciente.component.html',
  styleUrls: ['./registrar-paciente.component.css']
})
export class RegistrarPacienteComponent {

  @Output() pacienteRegistrado = new EventEmitter<Paciente>();

  constructor(private router: Router, private pacienteService: PacienteService) { }

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
      this.pacienteService.agregarPaciente(this.paciente).subscribe((response: any) => {
        console.log('Respuesta al agregar paciente:', response);
        this.router.navigate(['/administrador/pacientes']); // Redirige a la vista de la tabla de pacientes
      });
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }

}
