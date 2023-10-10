import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-barra-lateral-cliente',
  templateUrl: './barra-lateral-cliente.component.html',
  styleUrls: ['./barra-lateral-cliente.component.css']
})
export class BarraLateralClienteComponent {

  @Output() registrarCliente = new EventEmitter<void>();

  registrarNuevoCliente() {
    this.registrarCliente.emit();
  }
}
