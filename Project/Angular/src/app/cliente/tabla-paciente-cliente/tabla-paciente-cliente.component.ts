import {Component, Input, OnInit} from '@angular/core';
import {Paciente} from "../../paciente/paciente";
import {ActivatedRoute} from "@angular/router";
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";

@Component({
  selector: 'app-tabla-paciente-cliente',
  templateUrl: './tabla-paciente-cliente.component.html',
  styleUrls: ['./tabla-paciente-cliente.component.css']
})
export class TablaPacienteClienteComponent  {

  @Input() pacienteClienteLista: Paciente[] = [];

}
