import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {Paciente} from "../paciente";
import {ActivatedRoute} from "@angular/router";
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";

@Component({
  selector: 'app-tratamiento-paciente',
  templateUrl: './tratamiento-paciente.component.html',
  styleUrls: ['./tratamiento-paciente.component.css']
})
export class TratamientoPacienteComponent implements OnChanges, OnInit{
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
