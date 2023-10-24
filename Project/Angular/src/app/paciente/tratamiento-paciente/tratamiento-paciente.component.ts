import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { ClienteService } from "../../service/cliente/cliente.service";
import { PacienteService } from "../../service/paciente/paciente.service";
import { Tratamiento } from "../../tratamiento/tratamiento";
import { DrogaService } from "../../service/droga/droga.service";
import { TratamientoService } from "../../service/tratamiento/tratamiento.service";
import { Droga } from "../../droga/droga";
import { Veterinario } from "../../veterinario/veterinario";
import { Paciente } from "../paciente";
import { VeterinarioService } from "../../service/veterinario/veterinario.service";

@Component({
  selector: 'app-tratamiento-paciente',
  templateUrl: './tratamiento-paciente.component.html',
  styleUrls: ['./tratamiento-paciente.component.css']
})
export class TratamientoPacienteComponent implements OnInit {
  @Input() paciente: Paciente | null = null;
  @Input() droga: Droga | undefined;
  @Input() veterinario: Veterinario[] | null = null;
  @Output() tratamientoRegistrado = new EventEmitter<Tratamiento>();

  drogasDisponibles: Droga[] = [];
  selectedDroga: number = 0;
  veterinarioId: string | null = null;

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
      contrasena: '',
      nombre: '',
      especialidad: '',
      foto: '',
      estado: ''
    }
  };

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private clienteService: ClienteService,
    private pacienteService: PacienteService,
    private veterinarioService: VeterinarioService,
    private drogaService: DrogaService,
    private tratamientoService: TratamientoService
  ) {}

  ngOnInit() {
    const pacienteIdConsulta = this.route.snapshot.params['id'];
    this.pacienteService.getPacienteById(pacienteIdConsulta).subscribe(paciente => {
      this.paciente = paciente;
      console.log('Paciente con ID', pacienteIdConsulta, ':', paciente);
    });

    this.drogaService.getAllDrogas().subscribe(drogas => {
      this.drogasDisponibles = drogas.filter(droga => parseInt(droga.unidadesDisponibles) > 0);
      console.log('Drogas disponibles:', this.drogasDisponibles);
    });

    this.veterinarioService.getAllVeterinarios().subscribe(veterinarios => {
      this.veterinario = veterinarios;
      console.log('List of veterinarios:', veterinarios);
    });

    this.veterinarioId = sessionStorage.getItem('veterinarioID');
    console.log('veterinarioID', this.veterinarioId);
  }

  onSubmit(form: any) {
    if (form.valid) {
      if (this.veterinarioId) {
        const vetId = Number(this.veterinarioId);
        if (!isNaN(vetId)) {
          this.veterinarioService.getVeterinarioById(vetId).subscribe(veterinario => {
            if (veterinario) {
              console.log('Veterinario with ID', vetId, ':', veterinario);
              this.tratamiento.veterinario = veterinario;

              if (this.paciente !== null) {
                this.tratamiento.paciente = this.paciente;
              } else {
                alert('Error: No hay información del paciente disponible.');
                return;
              }

              this.drogaService.getDrogaById(this.selectedDroga).subscribe(droga => {
                if (droga) {
                  console.log('Droga con ID', this.selectedDroga, ':', droga);
                  this.tratamiento.droga = droga;

                  this.tratamientoService.agregarTratamiento(this.tratamiento).subscribe(response => {
                    console.log('Tratamiento creado:', this.tratamiento);
                    console.log('Respuesta del servidor al agregar tratamiento:', response);

                    droga.unidadesDisponibles = (parseInt(droga.unidadesDisponibles) - 1).toString();
                    droga.unidadesVendidas = (parseInt(droga.unidadesVendidas) + 1).toString();
                    this.drogaService.actualizarDroga(droga.id, droga).subscribe(response => {
                      console.log('Droga actualizada:', response);
                      this.router.navigate(['/veterinario/pacientes']);
                    });
                  });
                } else {
                  alert('La droga seleccionada no es válida o no está disponible.');
                  return;
                }
              }, error => {
                console.error('Error al obtener la droga por ID:', error);
                alert('Ocurrió un error al obtener la droga. Por favor, inténtelo de nuevo.');
              });
            } else {
              alert('No se pudo recuperar la información del veterinario.');
            }
          }, error => {
            console.error('Error al recuperar el veterinario:', error);
          });
        } else {
          console.error('veterinarioID en sessionStorage no es un número válido.');
        }
      } else {
        console.error('No veterinarioId available from sessionStorage.');
      }
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }
}
