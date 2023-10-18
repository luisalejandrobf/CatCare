import {Component, EventEmitter, OnInit, Output} from '@angular/core';
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
export class RegistrarClienteComponent implements OnInit {

  vista!: string;


  @Output() clienteRegistrado = new EventEmitter<Cliente>();

  constructor(private router: Router, private clienteService: ClienteService) {
  }


  ngOnInit() {
    // Obtiene la URL completa
    const fullPath = this.router.url;
    // Divide la URL por '/' y toma el primer segmento
    this.vista = fullPath.split('/')[1];
  }

// Objeto que representa un nuevo cliente a registrar.
  cliente: Cliente = {
    id: 0,
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

        // verifica la vista actual para realizar el routing al debido componente
        if (this.vista === 'administrador') {
          // Redirigir al usuario a la tabla de pacientes de un administrador
          this.router.navigate(['/administrador/clientes']); // Redirige a la vista de la tabla de clientes
        } else if (this.vista === 'veterinario') {
          // Redirigir al usuario a la tabla de pacientes de un veterinario
          this.router.navigate(['/veterinario/clientes']); // Redirige a la vista de la tabla de clientes
        }
      });
    } else {
      // Alerta al usuario si el formulario no está completo.
      alert('Por favor, completa el formulario correctamente.');
    }
  }
}
