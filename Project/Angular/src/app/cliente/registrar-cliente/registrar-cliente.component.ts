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
export class RegistrarClienteComponent {

  @Output() clienteRegistrado = new EventEmitter<Cliente>();

  constructor(private router: Router, private clienteService: ClienteService) { }


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
      this.clienteService.agregarCliente(this.cliente).subscribe((response: any) => {
        console.log('Respuesta al agregar cliente:', response);
        this.router.navigate(['/administrador/clientes']); // Redirige a la vista de la tabla de clientes
      });
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }

}
