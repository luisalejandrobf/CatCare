import {Component, EventEmitter, Output} from '@angular/core';
import {Paciente} from "../../paciente/paciente";
import {Cliente} from "../cliente";
import {Router} from "@angular/router";
import {PacienteService} from "../../service/paciente/paciente.service";
import {ClienteService} from "../../service/cliente/cliente.service";

@Component({
  selector: 'app-registrar-cliente',
  templateUrl: './registrar-cliente.component.html',
  styleUrls: ['./registrar-cliente.component.css']
})
// Componente para registrar un nuevo cliente.
export class RegistrarClienteComponent {

  @Output() clienteRegistrado = new EventEmitter<Cliente>();

  constructor(private router: Router, private clienteService: ClienteService) { }

// Objeto que representa un nuevo cliente a registrar.
  cliente: Cliente = {
    id:0,
    nombre: '',
    cedula: '',
    correo: '',
    celular: '',
    foto: ''
  };

  // Método que se ejecuta al enviar el formulario de registro.
  onSubmit(form: any) {
    if (form.valid) {
      // Verifica si el formulario es válido.
      this.clienteService.agregarCliente(this.cliente).subscribe((response: any) => {
        // Llama al servicio para agregar un nuevo cliente y maneja la respuesta
        console.log('Respuesta al agregar cliente:', response);
        this.router.navigate(['/administrador/clientes']); // Redirige a la vista de la tabla de clientes
      });
    } else {
      // Alerta al usuario si el formulario no está completo.
      alert('Por favor, completa el formulario correctamente.');
    }
  }

}
