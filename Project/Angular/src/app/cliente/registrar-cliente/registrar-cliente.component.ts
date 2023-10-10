import {Component, EventEmitter, Output} from '@angular/core';
import {Paciente} from "../../paciente/paciente";
import {Cliente} from "../cliente";

@Component({
  selector: 'app-registrar-cliente',
  templateUrl: './registrar-cliente.component.html',
  styleUrls: ['./registrar-cliente.component.css']
})
export class RegistrarClienteComponent {

  @Output() clienteRegistrado = new EventEmitter<Cliente>();


  cliente: Cliente = {
    id:0,
    nombre: '',
    cedula: '',
    correo: '',
    celular: '',
    foto: ''
  };

  onSubmit(form: any) {
    if (form.valid) {
      this.clienteRegistrado.emit(this.cliente);
      console.log('Evento clienteRegistrado emitido:', this.cliente);
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }

}
