// paciente.component.ts
import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {Paciente} from './paciente';
import {ClienteService} from "../service/cliente/cliente.service";
import {PacienteService} from "../service/paciente/paciente.service";
import {Cliente} from "../cliente/cliente";
import {Tratamiento} from "../tratamiento/tratamiento";
import {AdministradorService} from "../service/administrador/administrador.service";
import {DrogaService} from "../service/droga/droga.service";
import {TratamientoService} from "../service/tratamiento/tratamiento.service";
import {VeterinarioService} from "../service/veterinario/veterinario.service";
import {Veterinario} from "../veterinario/veterinario";

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
  mostrarTratarPaciente = false;



  // Inicializacion de la lista de pacientes aquí
  pacienteLista: Paciente[] = [];
  tratamientoLista: Paciente[] = [];

  constructor(private clienteService: ClienteService, private pacienteService: PacienteService, private cdRef: ChangeDetectorRef,
              private administradorService: AdministradorService,
              private drogaService: DrogaService,
              private tratamientoService: TratamientoService,
              private veterinarioServicio:VeterinarioService) {}

  //metodo para obtener todos los pacientes
  ngOnInit(): void {
    this.pacienteService.getAllPacientes().subscribe(pacienteLista => {
      this.pacienteLista = pacienteLista; // Asigna los datos a pacienteLista
      console.log('Pacientes:', this.pacienteLista); // Agrega este log para verificar los datos
    });

    this.veterinarioServicio.veterinarioHome().subscribe(
        (veterinarioData)=> {
          const veteRinario:Veterinario = veterinarioData
          sessionStorage.setItem('veterinarioIDTratamiento', String(veteRinario.id));


        }
    )
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
      this.actualizarListaPacientes(); // Actualiza la lista de pacientes
    });
  }

  actualizarListaPacientes() {
    this.pacienteService.getAllPacientes().subscribe(pacienteLista => {
      this.pacienteLista = pacienteLista;
      console.log('Pacientes actualizados:', this.pacienteLista);
    });
  }



  //metodo para mostrar el formulario de registro de pacientes
  registroPaciente() {
    this.mostrarTabla = false;
  }


  //metodo para mostrar el formulario de crear tratamientos
  tratarPacientes(paciente: Paciente) {
    this.mostrarTabla = false;
    this.mostrarInformacionPaciente = false;
    this.mostrarModificarPaciente = false;
    this.mostrarTratarPaciente = true;
    this.pacienteSeleccionado = paciente;

  }

  //metodo para agregar un nuevo tratamiento
  nuevoTratamiento(tratamiento: Tratamiento) {
    this.tratamientoService.agregarTratamiento(tratamiento).subscribe(response => {
      console.log('Respuesta al agregar tratamiento:', response);
      this.actualizarTratamientos(); // Actualiza la lista de pacientes
    });
  }

 // Actualiza la lista de tratamientos en el componente al recuperar la información
  actualizarTratamientos() {
    this.tratamientoService.getAllTratamientos().subscribe(tratamientoLista => {
      this.tratamientoLista = tratamientoLista;
      console.log('tratamientos actualizados:', this.tratamientoLista);
    });
  }



}
