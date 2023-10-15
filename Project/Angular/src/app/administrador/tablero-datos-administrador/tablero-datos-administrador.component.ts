import { Component } from '@angular/core';

@Component({
  selector: 'app-tablero-datos-administrador',
  templateUrl: './tablero-datos-administrador.component.html',
  styleUrls: ['./tablero-datos-administrador.component.css']
})
export class TableroDatosAdministradorComponent {

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
