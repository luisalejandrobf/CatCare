import { Component } from '@angular/core';
import { AdministradorService } from 'src/app/service/administrador/administrador.service';
import { ClienteService } from 'src/app/service/cliente/cliente.service';
import { DrogaService } from 'src/app/service/droga/droga.service';
import { PacienteService } from 'src/app/service/paciente/paciente.service';
import { TratamientoService } from 'src/app/service/tratamiento/tratamiento.service';
import { VeterinarioService } from 'src/app/service/veterinario/veterinario.service';

@Component({
  selector: 'app-tablero-datos-administrador',
  templateUrl: './tablero-datos-administrador.component.html',
  styleUrls: ['./tablero-datos-administrador.component.css']
})
export class TableroDatosAdministradorComponent {

  constructor(
    private clienteService: ClienteService,
    private pacienteService: PacienteService,
    private veterinarioService: VeterinarioService,
    private administradorService: AdministradorService,
    private drogaService: DrogaService,
    private tratamientoService: TratamientoService
  ) { }

  totalTratamientos = 50;
  tratamientosPorMedicamento = 20;
  veterinariosActivos = 15;
  veterinariosInactivos = 5;
  mascotasTotales = 100;
  mascotasActivas = 30;
  ventasTotales = 5000;
  gananciasTotales = 3000;
  tratamiento1 = 150;
  tratamiento2 = 200;
  tratamiento3 = 100;


  // Inicializar datos
  ngOnInit() {


    
  }

}
