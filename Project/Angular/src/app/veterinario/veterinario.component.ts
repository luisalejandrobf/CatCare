import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {Veterinario} from './veterinario';
import {ClienteService} from "../service/cliente/cliente.service";
import {VeterinarioService} from "../service/veterinario/veterinario.service";
import {Cliente} from "../cliente/cliente";

@Component({
  selector: 'app-veterinario',
  templateUrl: './veterinario.component.html',
  styleUrls: ['./veterinario.component.css']
})
export class VeterinarioComponent implements OnInit{
  mostrarTabla = true;
  mostrarInformacionVeterinario = false;
  veterinarioSeleccionado: Veterinario | null = null;
  mostrarModificarVeterinario = false;

  veterinarioLista: Veterinario[] = [];

  constructor(private clienteService: ClienteService, private veterinarioService: VeterinarioService, private cdRef: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.veterinarioService.getAllVeterinarios().subscribe(veterinarioLista => {
      this.veterinarioLista = veterinarioLista;
      console.log('Veterinarios:', this.veterinarioLista);
    });
  }

  informacionVeterinario(veterinario: Veterinario) {
    this.mostrarTabla = false;
    this.mostrarInformacionVeterinario = true;
    this.veterinarioSeleccionado = veterinario;
  }

  veterinarioModificado(datosVeterinarioActualizados: Veterinario) {
    const veterinarioIdActualizar = this.veterinarioLista.findIndex(veterinario => veterinario.nombre === datosVeterinarioActualizados.nombre);
    this.veterinarioService.actualizarVeterinario(veterinarioIdActualizar, datosVeterinarioActualizados).subscribe(response => {
      console.log('Respuesta al actualizar veterinario con ID', veterinarioIdActualizar, ':', response);
    });
    this.mostrarModificarVeterinario = false;
    this.mostrarTabla = true;
  }

  modificarVeterinarios(veterinario: Veterinario) {
    this.mostrarTabla = false;
    this.mostrarInformacionVeterinario = false;
    this.mostrarModificarVeterinario = true;
    this.veterinarioSeleccionado = veterinario;
  }

  nuevoVeterinario(veterinario: Veterinario) {
    this.veterinarioService.agregarVeterinario(veterinario).subscribe(response => {
      console.log('Respuesta al agregar veterinario:', response);
      this.actualizarListaVeterinarios();
    });
  }

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
