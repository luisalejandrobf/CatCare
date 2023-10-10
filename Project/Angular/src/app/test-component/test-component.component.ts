import { Component } from '@angular/core';
import { ClienteService } from '../service/cliente/cliente.service';
import { PacienteService } from '../service/paciente/paciente.service';


@Component({
  selector: 'app-test-component',
  templateUrl: './test-component.component.html',
  styleUrls: ['./test-component.component.css']
})
export class TestComponentComponent {

  constructor(private clienteService: ClienteService, private pacienteService: PacienteService) { }

  ngOnInit(): void {


    // Llamadas a métodos del servicio ClienteService

    // Obtener todos los clientes
    this.clienteService.getAllClientes().subscribe(clientes => {
      console.log('Clientes:', clientes);
    });

    // Obtener pacientes de un cliente específico
    const clienteId = 1;
    this.clienteService.getPacientesByClienteId(clienteId).subscribe(pacientes => {
      console.log('Pacientes del cliente con ID', clienteId, ':', pacientes);
    });

    // Obtener un cliente por ID
    const clienteIdConsulta = 2;
    this.clienteService.getClienteById(clienteIdConsulta).subscribe(cliente => {
      console.log('Cliente con ID', clienteIdConsulta, ':', cliente);
    });

    // Agregar un nuevo cliente
    const nuevoCliente = {
      nombre: 'Nuevo Cliente',
      // ...otros campos del cliente
    };
    this.clienteService.agregarCliente(nuevoCliente).subscribe(response => {
      console.log('Respuesta al agregar cliente:', response);
    });

    // Eliminar un cliente por ID
    const clienteIdEliminar = 3;
    this.clienteService.eliminarCliente(clienteIdEliminar).subscribe(response => {
      console.log('Respuesta al eliminar cliente con ID', clienteIdEliminar, ':', response);
    });

    // Actualizar un cliente por ID
    const clienteIdActualizar = 4;
    const datosActualizados = { // Esto se reemplaza por el objeto cliente
      "id": 4,
      "cedula": "5132532523",
      "nombre": "Aaactualizado!!!",
      "correo": "Maria.garcia2131@hotmail.com",
      "celular": "3112345678",
      "foto": "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"
    };
    this.clienteService.actualizarCliente(clienteIdActualizar, datosActualizados).subscribe(response => {
      console.log('Respuesta al actualizar cliente con ID', clienteIdActualizar, ':', response);
    });





    // Llamadas a métodos del servicio PacienteService

    // Obtener todos los pacientes
    this.pacienteService.getAllPacientes().subscribe(pacientes => {
      console.log('Pacientes:', pacientes);
    });

    // Obtener un paciente por ID
    const pacienteIdConsulta = 5;
    this.pacienteService.getPacienteById(pacienteIdConsulta).subscribe(paciente => {
      console.log('Paciente con ID', pacienteIdConsulta, ':', paciente);
    });

    // Agregar un nuevo paciente
    const nuevoPaciente = {
      nombre: 'Nuevo Paciente',
      // ...otros campos del paciente
    };
    this.pacienteService.agregarPaciente(nuevoPaciente).subscribe(response => {
      console.log('Respuesta al agregar paciente:', response);
    });

    // Eliminar un paciente por ID
    const pacienteIdEliminar = 1;
    this.pacienteService.eliminarPaciente(pacienteIdEliminar).subscribe(response => {
      console.log('Respuesta al eliminar paciente con ID', pacienteIdEliminar, ':', response);
    });

    // Actualizar un paciente por ID
    const pacienteIdActualizar = 7;
    const datosPacienteActualizados = { // Esto se reemplaza con el objeto paciente
      "id": 7,
      "nombre": "Actualizado el paciente!!",
      "raza": "Cornish Rex",
      "edad": 3,
      "peso": 15.7,
      "enfermedad": "Tos",
      "estado": "Activo",
      "foto": "https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg",
      "cliente": {
        "id": 2,
        "cedula": "231113124523",
        "nombre": "Felipe Garcia Castiblanco",
        "correo": "felipe.gar@javeriana.edu.co",
        "celular": "32424234334",
        "foto": "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"
      }
    };

    // Llamada al método actualizarPaciente del servicio PacienteService
    this.pacienteService.actualizarPaciente(pacienteIdActualizar, datosPacienteActualizados).subscribe(response => {
      console.log('Respuesta al actualizar paciente con ID', pacienteIdActualizar, ':', response);
    });


    // Esperar 2 segundos (2000 milisegundos)
    const tiempoEspera2 = 2000;

    setTimeout(() => {
      console.log('Han pasado 2 segundos...');

    // Mostrar todos los clientes
    this.clienteService.getAllClientes().subscribe(clientes => {
      console.log('Verificacion final para clientes...', clientes);
    });

    // Obtener todos los pacientes
    this.pacienteService.getAllPacientes().subscribe(pacientes => {
      console.log('Verificacion final para pacientes...', pacientes);
    });

    }, tiempoEspera2);
  }
}
