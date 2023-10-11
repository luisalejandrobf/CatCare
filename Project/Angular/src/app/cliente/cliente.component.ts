import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Cliente } from "./cliente";
import { ClienteService } from "../service/cliente/cliente.service";
import { PacienteService } from "../service/paciente/paciente.service";
import { Paciente } from "../paciente/paciente";

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  vista: 'pacientes' | 'clientes' | 'veterinarios' = 'pacientes';

  mostrarTabla = true;
  mostrarInformacionCliente = false;
  clienteSeleccionado: Cliente | null = null;
  mostrarModificarCliente = false;

  clienteLista: Cliente[] = [];
  pacienteClienteLista: Paciente[] = [];

  constructor(private route: ActivatedRoute, private clienteService: ClienteService, private pacienteService: PacienteService) { }

  ngOnInit() {
    const currentPath = this.route.snapshot.url[0]?.path;
    const idParam = this.route.snapshot.url[1]?.path;
    const subPath = this.route.snapshot.url[2]?.path;

    if (currentPath === 'cliente' && idParam && subPath === 'pacientes') {
      this.vista = 'pacientes';
    } else {
      this.vista = 'clientes';
    }

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

  informacionCliente(cliente: Cliente) {
    this.mostrarTabla = false;
    this.mostrarInformacionCliente = true;
    this.clienteSeleccionado = cliente;
  }

  clienteModificado(datosClienteActualizados: Cliente) {
    const clienteIdActualizar = this.clienteLista.findIndex(cliente => cliente.nombre === datosClienteActualizados.nombre);
    this.clienteService.actualizarCliente(clienteIdActualizar, datosClienteActualizados).subscribe(response => {
      console.log('Respuesta al actualizar cliente con ID', clienteIdActualizar, ':', response);
    });
    this.mostrarModificarCliente = false;
    this.mostrarTabla = true;
  }

  modificarClientes(cliente: Cliente) {
    this.mostrarTabla = false;
    this.mostrarInformacionCliente = false;
    this.mostrarModificarCliente = true;
    this.clienteSeleccionado = cliente;
  }

  nuevoCliente(cliente: Cliente) {
    this.clienteService.agregarCliente(cliente).subscribe(response => {
      console.log('Respuesta al agregar cliente:', response);
      this.actualizarListaClientes();
    });
  }

  actualizarListaClientes() {
    this.clienteService.getAllClientes().subscribe(clienteLista => {
      this.clienteLista = clienteLista;
      console.log('Clientes actualizados:', this.clienteLista);
    });
  }

  registroCliente() {
    this.mostrarTabla = false;
  }
}
