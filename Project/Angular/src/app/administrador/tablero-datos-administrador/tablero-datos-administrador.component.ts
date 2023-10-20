import { Component } from '@angular/core';
import { AdministradorService } from 'src/app/service/administrador/administrador.service';
import { ClienteService } from 'src/app/service/cliente/cliente.service';
import { DrogaService } from 'src/app/service/droga/droga.service';
import { PacienteService } from 'src/app/service/paciente/paciente.service';
import { TratamientoService } from 'src/app/service/tratamiento/tratamiento.service';
import { VeterinarioService } from 'src/app/service/veterinario/veterinario.service';
import { Tratamiento } from 'src/app/tratamiento/tratamiento';

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

  totalTratamientos = 0;
  drogaCantidadMap: Map<string, number> = new Map();
  veterinariosActivos = 0;
  veterinariosInactivos = 0;
  mascotasTotales = 0;
  mascotasActivas = 0;
  ventasTotales = "X";
  gananciasTotales = "X";
  top3MedicamentosMap: Map<string, number> = new Map();


  // Inicializar datos
  ngOnInit() {

    this.countTratamientosLastMonth();
    this.getDrogaCantidadLastMonth();
    this.getNumeroVeterinariosActivosInactivos();
    this.contarTotalMascotas();
    this.contarMascotasEnTratamiento();
    this.calcularVentasTotales();
    this.calcularGananciasTotales();
    this.getTop3MedicamentosUnidadesVendidas()

  }

  // Método para contar el número total de tratamientos en el último mes.
  countTratamientosLastMonth() {

    this.tratamientoService.getTratamientosUltimoMes().subscribe(response => {
      this.totalTratamientos = response
    });

  }

  // Método para obtener la cantidad de cada droga prescrita en el último mes.
  getDrogaCantidadLastMonth() {

    this.drogaService.getMedicamentosUltimoMes().subscribe(response => {
    
      for (const item of response) {
        const drogaNombre = item[0];
        const cantidad = item[1];
    
        this.drogaCantidadMap.set(drogaNombre, cantidad);
      }
    
      console.log(this.drogaCantidadMap);
    });

  }

  // Método para obtener el número de veterinarios activos e inactivos.
  getNumeroVeterinariosActivosInactivos() {

    this.veterinarioService.getVeterinariosActivos().subscribe(response => {
      this.veterinariosActivos = response
    });

    this.veterinarioService.getVeterinariosInactivos().subscribe(response => {
      this.veterinariosInactivos = response
    });

  }

  // Método para contar el total de mascotas registradas.
  contarTotalMascotas() {

    this.pacienteService.getTotalDeMascotas().subscribe(response => {
      this.mascotasTotales = response
    });

  }

  // Método para contar el número de mascotas actualmente en tratamiento.
  contarMascotasEnTratamiento() {

    this.tratamientoService.getMascotasActivas().subscribe(response => {
      this.mascotasActivas = response
    });
    
  }

  // Método para calcular el total de ventas.
  calcularVentasTotales() {

    let ventasTotalesAux = 0.0
    this.drogaService.getVentasTotales().subscribe(response => {
      ventasTotalesAux = response
      this.ventasTotales = ventasTotalesAux.toLocaleString('es-CO');
    });

  }

  // Método para calcular el total de ganancias.
  calcularGananciasTotales() {

    let gananciasTotalesAux = 0.0
    this.drogaService.getGananciasTotales().subscribe(response => {
      gananciasTotalesAux = response
      this.gananciasTotales = gananciasTotalesAux.toLocaleString('es-CO');
    });

  }

  // Método para obtener los tres medicamentos más vendidos.
  getTop3MedicamentosUnidadesVendidas() {

    this.drogaService.getTop3Tratamientos().subscribe(response => {
    
      for (const item of response) {
        const drogaNombre = item[0];
        const cantidad = item[1];
    
        this.top3MedicamentosMap.set(drogaNombre, cantidad);
      }
    
      console.log(this.top3MedicamentosMap);
    });

  }

  

}
