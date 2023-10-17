import {Component, Input, OnInit} from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { PacienteService } from "../../service/paciente/paciente.service";
import {Paciente} from "../paciente";
import {TratamientoService} from "../../service/tratamiento/tratamiento.service";
import {Tratamiento} from "../../tratamiento/tratamiento";

@Component({
  selector: 'app-historial-paciente',
  templateUrl: './historial-paciente.component.html',
  styleUrls: ['./historial-paciente.component.css']
})
export class HistorialPacienteComponent implements OnInit {
  tratamientos: any[] = [];
  @Input() paciente: Paciente | null = null;

  // Constructor donde se inyectan dependencias y se inicializan servicios.
  constructor(
      private route: ActivatedRoute,
      private pacienteService: PacienteService,
      private tratamientoService: TratamientoService
  ) {}
  ngOnInit() {
    // Obtiene el 'id' del paciente de la URL.
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



  eliminarTratamiento(tratamiento: Tratamiento) {
    this.tratamientoService.eliminarTratamiento(tratamiento.id).subscribe(response => {
      console.log('Respuesta al eliminar tratamiento con ID', tratamiento.id, ':', response);
      window.location.reload(); // Recarga la página (o podrías querer actualizar la lista sin recargar la página)
    }, error => {
      console.error('Hubo un error al eliminar el tratamiento:', error);
    });
  }
}
