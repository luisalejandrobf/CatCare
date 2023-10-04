import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {LandingComponent} from "./landing/landing.component";
import {PacienteComponent} from "./paciente/paciente.component";
import {TablaPacienteComponent} from "./paciente/tabla-paciente/tabla-paciente.component";
import {BarraLateralPacienteComponent} from "./paciente/barra-lateral-paciente/barra-lateral-paciente.component";
import {BarraSuperiorPacienteComponent} from "./paciente/barra-superior-paciente/barra-superior-paciente.component";


// Define las rutas de la aplicación
const routes: Routes = [
  {path: '', component: LandingComponent}, // Ruta raíz
  {
    path: 'paciente',
    component: PacienteComponent, // Componente principal para la ruta 'paciente'
    children: [ // Rutas hijas de 'paciente'
      {path: 'tabla-paciente', component: TablaPacienteComponent},
      {path: 'barra-lateral-paciennte', component: BarraLateralPacienteComponent},
      {path: 'barra-superior-paciente', component: BarraSuperiorPacienteComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Importa el módulo de enrutamiento con las rutas definidas
  exports: [RouterModule] // Exporta el módulo de enrutamiento para usarlo en otros módulos
})
export class AppRoutingModule { }
