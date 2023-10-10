import {Component, Input, OnChanges} from '@angular/core';
import {Paciente} from "../../paciente/paciente";
import {Cliente} from "../cliente";

@Component({
  selector: 'app-informacion-cliente',
  templateUrl: './informacion-cliente.component.html',
  styleUrls: ['./informacion-cliente.component.css']
})
export class InformacionClienteComponent implements OnChanges {

  @Input() cliente: Cliente | null = null;

  ngOnChanges() {
    console.log('Cliente recibido:', this.cliente);
  }


}
