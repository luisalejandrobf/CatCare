import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Cliente } from "./cliente";
import { ClienteService } from "../service/cliente/cliente.service";
import { PacienteService } from "../service/paciente/paciente.service";
import { Paciente } from "../paciente/paciente";
import {Router} from '@angular/router';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
// Componente principal para la gestión de clientes.
export class ClienteComponent implements OnInit {

  // Define la vista actual en la interfaz de cliente.
  vista: 'pacientes' | 'clientes' | 'veterinarios' = 'pacientes';

  // Controla la visualización de diferentes secciones en la interfaz.
  mostrarTabla = true;
  mostrarInformacionCliente = false;
  clienteSeleccionado: Cliente | null = null;
  mostrarModificarCliente = false;

  // Listas para almacenar los clientes y sus pacientes.
  clienteLista: Cliente[] = [];
  pacienteClienteLista: Paciente[] = [];

  constructor(private route: ActivatedRoute, private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router) { }

  ngOnInit() {

    // Verificar si hay token de cliente
    if ( localStorage.getItem('tokenCliente') == null){
      this.router.navigate(['/']); // Volver al landing.
    }


    // Determina la vista basada en la URL actual
    const currentPath = this.route.snapshot.url[0]?.path;
    const idParam = this.route.snapshot.url[1]?.path;
    const subPath = this.route.snapshot.url[2]?.path;

    if (currentPath === 'cliente' && idParam && subPath === 'pacientes') {
      this.vista = 'pacientes';
    } else {
      this.vista = 'clientes';
    }

    // Recupera la lista de todos los clientes.
    this.clienteService.getAllClientes().subscribe(clienteLista => {
      this.clienteLista = clienteLista;
      console.log('Clientes:', this.clienteLista);
    });

    const clienteId = this.route.snapshot.params['id']; // Aquí obtenemos el ID del cliente desde la ruta
    if (clienteId) {
      this.clienteService.getPacientesByClienteId(clienteId).subscribe(pacienteClienteLista => {
        this.pacienteClienteLista = pacienteClienteLista;
        console.log('Pacientes del cliente con ID', clienteId, ':', pacienteClienteLista);
      });
    }
  }

  // Muestra la información detallada de un cliente seleccionado.
  informacionCliente(cliente: Cliente) {
    this.mostrarTabla = false;
    this.mostrarInformacionCliente = true;
    this.clienteSeleccionado = cliente;
  }

  // Actualiza la información de un cliente.
  clienteModificado(datosClienteActualizados: Cliente) {
    const clienteIdActualizar = this.clienteLista.findIndex(cliente => cliente.nombre === datosClienteActualizados.nombre);
    this.clienteService.actualizarCliente(clienteIdActualizar, datosClienteActualizados).subscribe(response => {
      console.log('Respuesta al actualizar cliente con ID', clienteIdActualizar, ':', response);
    });
    this.mostrarModificarCliente = false;
    this.mostrarTabla = true;
  }

  // Prepara la interfaz para modificar la información de un cliente.
  modificarClientes(cliente: Cliente) {
    this.mostrarTabla = false;
    this.mostrarInformacionCliente = false;
    this.mostrarModificarCliente = true;
    this.clienteSeleccionado = cliente;
  }

  // Agrega un nuevo cliente y actualiza la lista de clientes.
  nuevoCliente(cliente: Cliente) {
    this.clienteService.agregarCliente(cliente).subscribe(response => {
      console.log('Respuesta al agregar cliente:', response);
      this.actualizarListaClientes();
    });
  }

  // Actualiza la lista de clientes recuperando la lista actualizada del servidor.
  actualizarListaClientes() {
    this.clienteService.getAllClientes().subscribe(clienteLista => {
      this.clienteLista = clienteLista;
      console.log('Clientes actualizados:', this.clienteLista);
    });
  }

  // Prepara la interfaz para el registro de un nuevo cliente.
  registroCliente() {
    this.mostrarTabla = false;
  }
}
