import {Component, EventEmitter, Input, OnChanges, OnInit, Output} from '@angular/core';
import {Paciente} from "../paciente";
import {ActivatedRoute, Router} from "@angular/router";
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {Tratamiento} from "../../tratamiento/tratamiento";
import {AdministradorService} from "../../service/administrador/administrador.service";
import {DrogaService} from "../../service/droga/droga.service";
import {TratamientoService} from "../../service/tratamiento/tratamiento.service";

@Component({
  selector: 'app-tratamiento-paciente',
  templateUrl: './tratamiento-paciente.component.html',
  styleUrls: ['./tratamiento-paciente.component.css']
})
export class TratamientoPacienteComponent implements OnChanges, OnInit {
  @Input() paciente: Paciente | null = null;
  @Output() tratamientoRegistrado = new EventEmitter<Tratamiento>();


  constructor(private router: Router,
              private route: ActivatedRoute,
              private clienteService: ClienteService,
              private pacienteService: PacienteService,
              private administradorService: AdministradorService,
              private drogaService: DrogaService,
              private tratamientoService: TratamientoService
  ) {}

  tratamiento: Tratamiento = {
    id: 0,
    fechaDeInicio: new Date(),
    paciente: {
      id: 0,
      nombre: '',
      raza: '',
      edad: '',
      peso: '',
      enfermedad: '',
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
    },
    droga: {
      id: 0,
      nombre: '',
      precioVenta: '',
      precioCompra: '',
      unidadesDisponibles: '',
      unidadesVendidas: ''
    },
    veterinario: {
      id: 0,
      cedula: '',
      nombre: '',
      contrasena: '',
      especialidad: '',
      foto: '',
      estado: ''
    }
  };

  ngOnInit() {
    const pacienteIdConsulta = this.route.snapshot.params['id'];
    // Carga la información del paciente usando pacienteId
    this.pacienteService.getPacienteById(pacienteIdConsulta).subscribe(paciente => {
      this.paciente = paciente;
      console.log('Paciente con ID', pacienteIdConsulta, ':', paciente);
    });
  }

  ngOnChanges() {
    console.log('Paciente recibido:', this.paciente);
  }

  onSubmit(form: any) {
    if (form.valid) {
      this.tratamientoService.agregarTratamiento(this.tratamiento).subscribe(response => {
        console.log('Respuesta al agregar tratamiento:', response);
        this.router.navigate(['/veterinario/pacientes']); // Redirige a la vista de la tabla de pacientes
      });
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }

}
