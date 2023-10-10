// paciente.component.ts
import {Component, Input, OnInit} from '@angular/core';
import {Paciente} from './paciente';
import {ClienteService} from "../service/cliente/cliente.service";
import {PacienteService} from "../service/paciente/paciente.service";

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.css']
})
export class PacienteComponent implements OnInit{
  //inicializar componentes para esconder o mostrar
  mostrarTabla = true;
  mostrarInformacionPaciente = false;
  pacienteSeleccionado: Paciente | null = null
  mostrarModificarPaciente = false;



  // Inicializacion de la lista de pacientes aquí
  pacienteLista: Paciente[] = [];

  constructor(private clienteService: ClienteService, private pacienteService: PacienteService) {}

  //metodo para obtener todos los pacientes
  ngOnInit(): void {
    this.pacienteService.getAllPacientes().subscribe(pacienteLista => {
      this.pacienteLista = pacienteLista; // Asigna los datos a pacienteLista
      console.log('Pacientes:', this.pacienteLista); // Agrega este log para verificar los datos
    });
  }

//metodo para mostrar la informacion de pacientes y esconde los componentes de los pacientes
  informacionPaciente(paciente: Paciente) {
    this.mostrarTabla = false;
    this.mostrarInformacionPaciente = true;
    this.pacienteSeleccionado = paciente;
  }

  //metodo para modificar los pacientes
  pacienteModificado(datosPacienteActualizados: Paciente) {
    // Actualizar un paciente por ID
    const pacienteIdActualizar = this.pacienteLista.findIndex(paciente => paciente.nombre === datosPacienteActualizados.nombre);

    // Llamada al método actualizarPaciente del servicio PacienteService
    this.pacienteService.actualizarPaciente(pacienteIdActualizar, datosPacienteActualizados).subscribe(response => {
      console.log('Respuesta al actualizar paciente con ID', pacienteIdActualizar, ':', response);
    });

    // Muestra la tabla de pacientes
    this.mostrarModificarPaciente = false;
    this.mostrarTabla = true;
  }

  //metodo para mostrar la modificacion de pacientes y esconde los componentes de los pacientes
  modificarPacientes(paciente: Paciente) {
    this.mostrarTabla = false;
    this.mostrarInformacionPaciente = false;
    this.mostrarModificarPaciente = true;
    this.pacienteSeleccionado = paciente;
  }


  //metodo para agregar un nuevo paciente
  nuevoPaciente(paciente: Paciente) {
    this.pacienteService.agregarPaciente(paciente).subscribe(response => {
      console.log('Respuesta al agregar paciente:', response);
    });
    console.log('Nuevo paciente añadido:', paciente); // Añade este log
    console.log('Lista de pacientes actualizada:', this.pacienteLista); // Añade este log
    this.mostrarTabla = true; // Muestra la tabla de pacientes
  }


  //metodo para mostrar el formulario de registro de pacientes
  registroPaciente() {
    this.mostrarTabla = false;
  }

}
