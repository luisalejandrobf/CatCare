import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Paciente} from "../../paciente/paciente";
import {Cliente} from "../cliente";

@Component({
  selector: 'app-modificar-cliente',
  templateUrl: './modificar-cliente.component.html',
  styleUrls: ['./modificar-cliente.component.css']
})
export class ModificarClienteComponent {

  @Input() cliente: Cliente | null = null;
  @Output() clienteModificado = new EventEmitter<Cliente>();

  enviarFormulario() {
    if (this.cliente) {
      this.clienteModificado.emit(this.cliente);
    }
  }
}
