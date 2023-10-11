import {Component, Input, EventEmitter, Output} from '@angular/core';
import {Paciente} from '../paciente';
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {Cliente} from "../../cliente/cliente";
import {Router} from '@angular/router';


@Component({
  selector: 'app-tabla-paciente',
  templateUrl: './tabla-paciente.component.html',
  styleUrls: ['./tabla-paciente.component.css']
})
export class TablaPacienteComponent {

  constructor(private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router) {
  }


  @Input() pacienteLista: Paciente[] = [];
  @Output() verInformacionPaciente = new EventEmitter<Paciente>();
  @Output() modificarPaciente = new EventEmitter<Paciente>();



  informacionCliente(cliente: Cliente) {
    this.router.navigate(['/administrador/clientes/info', cliente.id]);
  }


  eliminarPacientes(paciente: Paciente) {
    this.pacienteService.eliminarPaciente(paciente.id).subscribe(response => {
      console.log('Respuesta al eliminar paciente con ID', paciente.id, ':', response);
      window.location.reload();
    });
  }
}


