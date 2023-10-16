import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { ClienteService } from "../../service/cliente/cliente.service";
import { PacienteService } from "../../service/paciente/paciente.service";
import { Tratamiento } from "../../tratamiento/tratamiento";
import { AdministradorService } from "../../service/administrador/administrador.service";
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
  @Input() droga: Droga | undefined; // Cambiado de Droga[] | null a Droga | undefined
  @Input() veterinario: Veterinario[] | null = null;
  @Output() tratamientoRegistrado = new EventEmitter<Tratamiento>();

  drogasDisponibles: Droga[] = [];
  contrasena: string = '';
  isPasswordCorrect: boolean = true; // Suponemos que la contraseña es correcta inicialmente
  selectedDroga: number = 0; // o cualquier otro valor predeterminado válido

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
    // Carga la información del paciente usando pacienteId
    this.pacienteService.getPacienteById(pacienteIdConsulta).subscribe(paciente => {
      this.paciente = paciente;
      console.log('Paciente con ID', pacienteIdConsulta, ':', paciente);
    });

    // carga la informacion de drogas en una lista de drogas (medicamentos), para mostrarlas en el formulario
    this.drogaService.getAllDrogas().subscribe(drogas => {
      this.drogasDisponibles = drogas.filter(droga => parseInt(droga.unidadesDisponibles) > 0);
      console.log('Drogas disponibles:', this.drogasDisponibles);
    });

    // Conseguir todos los veterinarios
    this.veterinarioService.getAllVeterinarios().subscribe(veterinarios => {
      this.veterinario = veterinarios;
      console.log('List of veterinarios:', veterinarios);
    });
  }

  onSubmit(form: any) {
    if (form.valid) {
      console.log('Contrasena ingresada:', this.contrasena); // Registrar la contraseña ingresada
      console.log('Cedula de veterinario ingresada:', this.tratamiento.veterinario.cedula); // Registrar la cédula ingresada

      // Asegurarse de que 'this.veterinario' no sea 'null' o 'undefined'
      if (this.veterinario) {
        // Buscar el veterinario por cédula
        const veterinarioSeleccionado = this.veterinario.find(vet => vet.cedula === this.tratamiento.veterinario.cedula);

        if (veterinarioSeleccionado) {
          console.log('Veterinario encontrado:', veterinarioSeleccionado); // Registrar los detalles del veterinario encontrado

          // Verificar si la contraseña ingresada coincide con la del veterinario
          if (this.contrasena === veterinarioSeleccionado.contrasena) {
            // La contraseña es correcta, proceder con la lógica de tratamiento

            // Completar el objeto tratamiento con los datos del formulario y los datos recuperados
            this.tratamiento.veterinario = veterinarioSeleccionado; // Asignar el veterinario seleccionado

            // Verificar si 'this.paciente' no es 'null' antes de asignarlo
            if (this.paciente !== null) {
              this.tratamiento.paciente = this.paciente; // Asignar el paciente actual
            } else {
              alert('Error: No hay información del paciente disponible.');
              return; // Salir del método si no hay datos del paciente
            }

            // Asignar la droga seleccionada usando 'this.selectedDroga'
            this.drogaService.getDrogaById(this.selectedDroga).subscribe(droga => {
              if (droga) {
                console.log('Droga con ID', this.selectedDroga, ':', droga);
                this.tratamiento.droga = droga;

                // Proceder con la creación del tratamiento y actualización de unidades de droga
                this.tratamientoService.agregarTratamiento(this.tratamiento).subscribe(response => {
                  console.log('Tratamiento creado:', this.tratamiento); // Registrar el tratamiento
                  console.log('Respuesta del servidor al agregar tratamiento:', response); // Registrar la respuesta del servidor

                  // Actualizar las unidades de la droga
                  droga.unidadesDisponibles = (parseInt(droga.unidadesDisponibles) - 1).toString();
                  droga.unidadesVendidas = (parseInt(droga.unidadesVendidas) + 1).toString();
                  this.drogaService.actualizarDroga(droga.id, droga).subscribe(response => {
                    console.log('Droga actualizada:', response);
                    this.router.navigate(['/veterinario/pacientes']); // Redirigir después de la actualización exitosa
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
            // La contraseña es incorrecta, mostrar mensaje de error
            alert('La contrasena es incorrecta.');
          }
        } else {
          // No se encontró el veterinario con la cédula proporcionada, mostrar mensaje de error
          alert('No existe un veterinario con la cédula proporcionada.');
        }
      } else {
        // 'this.veterinario' es 'null', manejar este caso como prefieras
        alert('Error: No hay información de veterinarios disponible.');
      }
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }
}
