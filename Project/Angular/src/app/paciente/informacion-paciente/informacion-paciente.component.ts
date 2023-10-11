import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {Paciente} from "../paciente";
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-informacion-paciente',
  templateUrl: './informacion-paciente.component.html',
  styleUrls: ['./informacion-paciente.component.css']
})
export class InformacionPacienteComponent implements OnChanges, OnInit {
  @Input() paciente: Paciente | null = null;


  constructor(private route: ActivatedRoute, private clienteService: ClienteService, private pacienteService: PacienteService) {}

  ngOnInit() {
    const pacienteIdConsulta = this.route.snapshot.params['id'];
    // Carga la información del paciente usando pacienteId
    this.pacienteService.getPacienteById(pacienteIdConsulta).subscribe(paciente => {
      this.paciente = paciente;
      console.log('Paciente con ID', pacienteIdConsulta, ':', paciente);
    });
  }

  ngOnChanges() {
    console.log('Paciente recibido:', this.paciente);
  }

}
