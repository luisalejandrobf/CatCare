import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Cliente} from "./cliente";
import {ClienteService} from "../service/cliente/cliente.service";
import {PacienteService} from "../service/paciente/paciente.service";
import {Paciente} from "../paciente/paciente";

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  vista: 'pacientes' | 'clientes' | 'veterinarios' = 'pacientes';

  cedula: string | null = '';

  //inicializar componentes para esconder o mostrar
  mostrarTabla = true;
  mostrarInformacionCliente = false;
  clienteSeleccionado: Cliente | null = null
  mostrarModificarCliente = false;

  // Inicializacion de la lista de pacientes aquí
  clienteLista: Cliente[] = [];
  pacienteClienteLista: Paciente[] = [];

  constructor(private route: ActivatedRoute, private clienteService: ClienteService, private pacienteService: PacienteService) {}

  ngOnInit() {
    const currentPath = this.route.snapshot.url[1]?.path;
    if (currentPath === 'clientes') {
      this.vista = 'clientes';
    } else if (currentPath === 'veterinarios') {
      this.vista = 'veterinarios';
    }
    //metodo para obtener todos los clientes
    this.clienteService.getAllClientes().subscribe(clienteLista => {
      this.clienteLista = clienteLista; // Asigna los datos a clientesLista
      console.log('Clientes:', this.clienteLista); // Agrega este log para verificar los datos
    });

    const clienteId = 2;
    this.clienteService.getPacientesByClienteId(clienteId).subscribe(pacienteClienteLista => {
      this.pacienteClienteLista = pacienteClienteLista;
      console.log('Pacientes del cliente con ID', clienteId, ':', pacienteClienteLista);
    });

    // Recuperar el valor del parámetro 'cedula'
    this.cedula = this.route.snapshot.paramMap.get('cedula');
    console.log('Cédula recibida:', this.cedula);
  }


//metodo para mostrar la informacion de pacientes y esconde los componentes de los pacientes
  informacionCliente(cliente: Cliente) {
    this.mostrarTabla = false;
    this.mostrarInformacionCliente = true;
    this.clienteSeleccionado = cliente;
  }

  //metodo para modificar los clientes
  clienteModificado(datosClienteActualizados: Cliente) {
    // Actualizar un cliente por ID
    const clienteIdActualizar = this.clienteLista.findIndex(cliente => cliente.nombre === datosClienteActualizados.nombre);

    // Llamada al método actualizar Cliente del servicio PacienteService
    this.clienteService.actualizarCliente(clienteIdActualizar, datosClienteActualizados).subscribe(response => {
      console.log('Respuesta al actualizar cliente con ID', clienteIdActualizar, ':', response);
    });

    // Muestra la tabla de pacientes
    this.mostrarModificarCliente = false;
    this.mostrarTabla = true;
  }

  //metodo para mostrar la modificacion de clientes y esconde los componentes de los clientes
  modificarClientes(cliente: Cliente) {
    this.mostrarTabla = false;
    this.mostrarInformacionCliente = false;
    this.mostrarModificarCliente = true;
    this.clienteSeleccionado = cliente;
  }


  //metodo para agregar un nuevo cliente
  nuevoCliente(cliente: Cliente) {
    this.clienteService.agregarCliente(cliente).subscribe(response => {
      console.log('Respuesta al agregar cliente:', response);
    });
    console.log('Nuevo cliente añadido:', cliente); // Añade este log
    console.log('Lista de clienntes actualizada:', this.clienteLista); // Añade este log
    this.mostrarTabla = true; // Muestra la tabla de pacientes
    window.location.reload();
  }


  //metodo para mostrar el formulario de registro de clientes
  registroCliente() {
    this.mostrarTabla = false;
  }

}
