import {Component, Input, OnChanges} from '@angular/core';
import {Paciente} from "../paciente";

@Component({
  selector: 'app-informacion-paciente',
  templateUrl: './informacion-paciente.component.html',
  styleUrls: ['./informacion-paciente.component.css']
})
export class InformacionPacienteComponent implements OnChanges {
  @Input() paciente: Paciente | null = null;

  ngOnChanges() {
    console.log('Paciente recibido:', this.paciente);
  }
}
