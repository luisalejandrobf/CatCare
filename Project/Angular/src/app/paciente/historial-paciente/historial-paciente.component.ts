import {Component, Input, OnInit} from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { PacienteService } from "../../service/paciente/paciente.service";
import {Paciente} from "../paciente";

@Component({
  selector: 'app-historial-paciente',
  templateUrl: './historial-paciente.component.html',
  styleUrls: ['./historial-paciente.component.css']
})
export class HistorialPacienteComponent implements OnInit {
  tratamientos: any[] = [];
  @Input() paciente: Paciente | null = null;
  constructor(private route: ActivatedRoute, private pacienteService: PacienteService) {}

  ngOnInit() {
    const pacienteId = this.route.snapshot.params['id'];


    //Carga del paciente
    this.pacienteService.getPacienteById(pacienteId).subscribe(paciente => {
      this.paciente = paciente;
      console.log('Paciente con ID', pacienteId, ':', paciente);
    });




    // Carga los tratamientos del paciente usando el ID
    this.pacienteService.getTratamientosByPacienteId(pacienteId).subscribe(tratamientos => {
      this.tratamientos = tratamientos;
      console.log('Tratamientos para el paciente con ID', pacienteId, ':', tratamientos);
    });
  }
}
