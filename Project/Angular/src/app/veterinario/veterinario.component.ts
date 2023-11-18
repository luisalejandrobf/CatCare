import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {Veterinario} from './veterinario';
import {ClienteService} from "../service/cliente/cliente.service";
import {VeterinarioService} from "../service/veterinario/veterinario.service";
import {ActivatedRoute} from "@angular/router";
import {LandbotService} from "../service/landbot/landbot-service.service";
import {Router} from '@angular/router';

@Component({
  selector: 'app-veterinario',
  templateUrl: './veterinario.component.html',
  styleUrls: ['./veterinario.component.css']
})
export class VeterinarioComponent implements OnInit {
  mostrarTabla = true;
  mostrarInformacionVeterinario = false;
  veterinarioSeleccionado: Veterinario | null = null;
  mostrarModificarVeterinario = false;

  veterinarioLista: Veterinario[] = [];

  // Variable para controlar qué vista se está mostrando.
  vista: 'pacientes' | 'clientes' | 'veterinarios' | 'veterinario' = 'pacientes';

  // Inyección de dependencias necesarias para el componente.
  constructor(private clienteService: ClienteService, private veterinarioService: VeterinarioService, private cdRef: ChangeDetectorRef, private route: ActivatedRoute, private landbotService: LandbotService, private router: Router) {
  }


  ngOnInit(): void {

    // Verificar si hay token de cliente
    if ( localStorage.getItem('tokenVeterinario') == null){
      this.router.navigate(['/']); // Volver al landing.
    }

    const currentPath = this.route.snapshot.url[0]?.path;
    const subPathOne = this.route.snapshot.url[1]?.path;

    if (currentPath === 'veterinario') {
      if (subPathOne === 'pacientes') {
        this.vista = 'pacientes';
      } else {
        this.vista = 'clientes';
      }
    } else {
      this.vista = 'veterinarios';
    }

    // Obtener todos los veterinarios y guardarlos en la lista.
    this.veterinarioService.getAllVeterinarios().subscribe(veterinarioLista => {
      this.veterinarioLista = veterinarioLista;
      console.log('Veterinarios:', this.veterinarioLista);
    });


    this.initLandbot()

  }

  initLandbot(): void {
    this.landbotService.initLandbot();
  }

  // Método para mostrar información de un veterinario específico.
  informacionVeterinario(veterinario: Veterinario) {
    this.mostrarTabla = false;
    this.mostrarInformacionVeterinario = true;
    this.veterinarioSeleccionado = veterinario;
  }

  // Método para manejar la lógica cuando un veterinario es modificado.
  veterinarioModificado(datosVeterinarioActualizados: Veterinario) {
    const veterinarioIdActualizar = this.veterinarioLista.findIndex(veterinario => veterinario.nombre === datosVeterinarioActualizados.nombre);
    this.veterinarioService.actualizarVeterinario(veterinarioIdActualizar, datosVeterinarioActualizados).subscribe(response => {
      console.log('Respuesta al actualizar veterinario con ID', veterinarioIdActualizar, ':', response);
    });
    this.mostrarModificarVeterinario = false;
    this.mostrarTabla = true;
  }

  // Método para preparar la vista de modificación de un veterinario.
  modificarVeterinarios(veterinario: Veterinario) {
    this.mostrarTabla = false;
    this.mostrarInformacionVeterinario = false;
    this.mostrarModificarVeterinario = true;
    this.veterinarioSeleccionado = veterinario;
  }

  // Método para agregar un nuevo veterinario.
  nuevoVeterinario(veterinario: Veterinario) {
    this.veterinarioService.agregarVeterinario(veterinario).subscribe(response => {
      console.log('Respuesta al agregar veterinario:', response);
      this.actualizarListaVeterinarios();
    });
  }

  // Método para actualizar la lista de veterinarios.
  actualizarListaVeterinarios() {
    this.veterinarioService.getAllVeterinarios().subscribe(veterinarioLista => {
      this.veterinarioLista = veterinarioLista;
      console.log('Veterinarios actualizados:', this.veterinarioLista);
    });
  }

  registroVeterinario() {
    this.mostrarTabla = false;
  }
}
