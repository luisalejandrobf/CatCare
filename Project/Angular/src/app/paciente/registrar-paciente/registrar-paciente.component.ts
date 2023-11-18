import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Paciente} from "../paciente";
import {Cliente} from "../../cliente/cliente";
import {Router} from "@angular/router";
import {PacienteService} from "../../service/paciente/paciente.service";
import {ClienteService} from "../../service/cliente/cliente.service";

@Component({
  selector: 'app-registrar-paciente',
  templateUrl: './registrar-paciente.component.html',
  styleUrls: ['./registrar-paciente.component.css']
})
export class RegistrarPacienteComponent implements OnInit{

  vista!: string;

  clienteLista: Cliente[] = [];

  @Output() pacienteRegistrado = new EventEmitter<Paciente>();

  // Constructor del componente, donde se inyectan dependencias.
  constructor(private router: Router, private clienteService: ClienteService, private pacienteService: PacienteService) {
  }


  ngOnInit() {
    // Obtiene la URL completa
    const fullPath = this.router.url;
    // Divide la URL por '/' y toma el primer segmento
    this.vista = fullPath.split('/')[1];

    // Recupera la lista de todos los clientes.
    this.clienteService.getAllClientes().subscribe(clienteLista => {
      this.clienteLista = clienteLista;
      console.log('Clientes:', this.clienteLista);
    });
  }

  // Objeto que representa un nuevo paciente, con estructura basada en el modelo 'Paciente'.

  paciente: Paciente = {
    id: 0,
    nombre: '',
    raza: '',
    edad: '',
    peso: '',
    estado: '',
    foto: '',
    cliente: {
      id: 0,
      cedula: '',
      nombre: '',
      correo: '',
      celular: '',
      foto: ''
    }
  };

  // Método que se ejecuta cuando se envía el formulario de registro de paciente.
  onSubmit(form: any) {
    if (form.valid) {
      this.pacienteService.agregarPaciente(this.paciente).subscribe((response: any) => {
        console.log('Respuesta al agregar paciente:', response);

        // verificacion de las vistas  para redirigir la componente deseado
        if (this.vista === 'administrador') {
          // Redirigir al usuario a la tabla de pacientes de un administrador
          this.router.navigate(['/administrador/pacientes']); // Redirige a la vista de la tabla de pacientes
        } else if (this.vista === 'veterinario') {
          // Redirigir al usuario a la tabla de pacientes de un veterinario
          this.router.navigate(['/veterinario/pacientes']); // Redirige a la vista de la tabla de pacientes
        }

      });
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }
}


