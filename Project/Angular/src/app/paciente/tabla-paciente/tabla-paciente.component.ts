import { Component, Input, EventEmitter, Output } from '@angular/core';
import { Paciente } from '../paciente';
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {Cliente} from "../../cliente/cliente";

@Component({
  selector: 'app-tabla-paciente',
  templateUrl: './tabla-paciente.component.html',
  styleUrls: ['./tabla-paciente.component.css']
})
export class TablaPacienteComponent {

  constructor(private clienteService: ClienteService, private pacienteService: PacienteService) {}



  @Input() pacienteLista: Paciente[] = [];
  @Output() verInformacionPaciente = new EventEmitter<Paciente>();
  @Output() modificarPaciente = new EventEmitter<Paciente>();


  informacionPacientes(paciente: Paciente) {
    this.verInformacionPaciente.emit(paciente);
  }

  informacionCliente(cliente: Cliente) {
    //metodo para recibir el id del cliente y luego redireccionar a un nuevo compoente con ese id
  }
  modificarPacientes(paciente: Paciente) {
    this.modificarPaciente.emit(paciente);
  }

  eliminarPacientes(paciente: Paciente) {
    this.pacienteService.eliminarPaciente(paciente.id).subscribe(response => {
      console.log('Respuesta al eliminar paciente con ID', paciente.id, ':', response);
      window.location.reload();
    });
  }
}


