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
    const currentDate: Date = new Date();
    const lastMonthDate: Date = new Date();
    lastMonthDate.setMonth(lastMonthDate.getMonth() - 1);

    this.tratamientoService.getAllTratamientos().subscribe(
      (tratamientos: Tratamiento[]) => {
        if (tratamientos && tratamientos.length) {
          const count = tratamientos.filter((tratamiento: Tratamiento) => {
            const tratamientoDate = new Date(tratamiento.fechaDeInicio);
            return tratamientoDate >= lastMonthDate && tratamientoDate <= currentDate;
          }).length;
          this.totalTratamientos = count; // Asigna el valor a totalTratamientos aquí
          console.log(`Number of tratamientos in the last month including today: ${this.totalTratamientos}`);
        }
      },
      (error) => {
        console.error('Error occurred:', error);
      }
    );
  }

  // Método para obtener la cantidad de cada droga prescrita en el último mes.
  getDrogaCantidadLastMonth() {
    const currentDate: Date = new Date();
    const lastMonthDate: Date = new Date();
    lastMonthDate.setMonth(lastMonthDate.getMonth() - 1);

    this.tratamientoService.getAllTratamientos().subscribe((tratamientos: Tratamiento[]) => {
      tratamientos.forEach((tratamiento: Tratamiento) => {
        const tratamientoDate = new Date(tratamiento.fechaDeInicio);
        if (tratamientoDate >= lastMonthDate && tratamientoDate <= currentDate) {
          const drogaNombre = tratamiento.droga.nombre;
          if (this.drogaCantidadMap.has(drogaNombre)) {
            this.drogaCantidadMap.set(drogaNombre, this.drogaCantidadMap.get(drogaNombre)! + 1);
          } else {
            this.drogaCantidadMap.set(drogaNombre, 1);
          }
        }
      });
    });

    console.log("drogaCantidadMap");
    console.log(this.drogaCantidadMap);
  }

  // Método para obtener el número de veterinarios activos e inactivos.
  getNumeroVeterinariosActivosInactivos() {
    this.veterinarioService.getAllVeterinarios().subscribe(veterinarios => {
      veterinarios.forEach(veterinario => {
        if (veterinario.estado === 'Activo') {
          this.veterinariosActivos++;
        } else if (veterinario.estado === 'Inactivo') {
          this.veterinariosInactivos++;
        }
      });

      console.log('Número de veterinarios activos:', this.veterinariosActivos);
      console.log('Número de veterinarios inactivos:', this.veterinariosInactivos);
    });
  }

  // Método para contar el total de mascotas registradas.
  contarTotalMascotas() {

    this.pacienteService.getAllPacientes().subscribe(pacientes => {

      this.mascotasTotales = pacientes.length;

      console.log('Total de mascotas:', this.mascotasTotales);
    });

  }

  // Método para contar el número de mascotas actualmente en tratamiento.
  contarMascotasEnTratamiento() {
    this.tratamientoService.getAllTratamientos().subscribe(tratamientos => {
      const mascotasEnTratamiento = new Set();
      tratamientos.forEach(tratamiento => {
        if (tratamiento.paciente && tratamiento.paciente.id) {
          mascotasEnTratamiento.add(tratamiento.paciente.id);
        }
      });
      const cantidadDiferentesMascotas = mascotasEnTratamiento.size;
      console.log('Cantidad de diferentes mascotas en tratamiento:', cantidadDiferentesMascotas);
      this.mascotasActivas = cantidadDiferentesMascotas;
    });
  }

  // Método para calcular el total de ventas.
  calcularVentasTotales() {

    let ventasTotalesAux = 0

    // Obtener todas las drogas
    this.drogaService.getAllDrogas().subscribe(drogas => {
      drogas.forEach(droga => {
        if (droga.unidadesVendidas && droga.precioVenta) {
          const unidadesVendidas = parseInt(droga.unidadesVendidas, 10);
          const precioVenta = parseFloat(droga.precioVenta);
          ventasTotalesAux += unidadesVendidas * precioVenta;
        }
      });

      this.ventasTotales = ventasTotalesAux.toLocaleString('es-CO');

      console.log('Ventas totales de la veterinaria:', this.ventasTotales);
    });
  }

  // Método para calcular el total de ganancias.
  calcularGananciasTotales() {
    let gananciasTotalesAux = 0;

    // Obtener todas las drogas
    this.drogaService.getAllDrogas().subscribe(drogas => {
      drogas.forEach(droga => {
        if (droga.unidadesVendidas && droga.precioVenta && droga.precioCompra) {
          const unidadesVendidas = parseInt(droga.unidadesVendidas, 10);
          const precioVenta = parseFloat(droga.precioVenta);
          const precioCompra = parseFloat(droga.precioCompra);
          const gananciaPorDroga = (precioVenta - precioCompra) * unidadesVendidas;
          gananciasTotalesAux += gananciaPorDroga;
        }
      });

      this.gananciasTotales = gananciasTotalesAux.toLocaleString('es-CO');

      console.log('Ganancias totales de la veterinaria:', this.gananciasTotales);
    });
  }

  // Método para obtener los tres medicamentos más vendidos.
  getTop3MedicamentosUnidadesVendidas() {

    let drogaCantidadMapAux = new Map<string, number>();


    this.tratamientoService.getAllTratamientos().subscribe((tratamientos: Tratamiento[]) => {
      tratamientos.forEach((tratamiento: Tratamiento) => {
        const drogaNombre = tratamiento.droga.nombre;
        if (drogaCantidadMapAux.has(drogaNombre)) {
          drogaCantidadMapAux.set(drogaNombre, drogaCantidadMapAux.get(drogaNombre)! + 1);
        } else {
          drogaCantidadMapAux.set(drogaNombre, 1);
        }
      });

      // Ordenar el mapa por valores en orden descendente y tomar los tres primeros elementos
      const sortedDrogaCantidadArray = Array.from(drogaCantidadMapAux).sort((a, b) => b[1] - a[1]).slice(0, 3);
      const top3DrogasUnidadesVendidas = new Map(sortedDrogaCantidadArray);

      console.log("Top 3 de medicamentos con más unidades vendidas en todos los tiempos:");
      console.log(top3DrogasUnidadesVendidas);
      this.top3MedicamentosMap = top3DrogasUnidadesVendidas;

    });
  }

}
