import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {LandingComponent} from "./landing/landing.component";
import {AdministradorComponent} from "./administrador/administrador.component";
import {TestComponentComponent} from "./test-component/test-component.component";
import {VeterinarioComponent} from "./veterinario/veterinario.component";
import {ClienteComponent} from "./cliente/cliente.component";
import {InformacionPacienteComponent} from "./paciente/informacion-paciente/informacion-paciente.component";
import {ModificarPacienteComponent} from "./paciente/modificar-paciente/modificar-paciente.component";
import {RegistrarPacienteComponent} from "./paciente/registrar-paciente/registrar-paciente.component";
import {PacienteComponent} from "./paciente/paciente.component";
import {InformacionClienteComponent} from "./cliente/informacion-cliente/informacion-cliente.component";
import {ModificarClienteComponent} from "./cliente/modificar-cliente/modificar-cliente.component";
import {RegistrarClienteComponent} from "./cliente/registrar-cliente/registrar-cliente.component";
import {ModificarVeterinarioComponent} from "./veterinario/modificar-veterinario/modificar-veterinario.component";
import {InformacionVeterinarioComponent} from "./veterinario/informacion-veterinario/informacion-veterinario.component";
import {RegistrarVeterinarioComponent} from "./veterinario/registrar-veterinario/registrar-veterinario.component";
import {
  TableroDatosAdministradorComponent
} from "./administrador/tablero-datos-administrador/tablero-datos-administrador.component";
import {TratamientoPacienteComponent} from "./paciente/tratamiento-paciente/tratamiento-paciente.component";
import {HistorialPacienteComponent} from "./paciente/historial-paciente/historial-paciente.component";
import {Error404Component} from './error/error404/error404.component';

// Define las rutas de la aplicación
const routes: Routes = [
  // Ruta raíz (ruta del landing page)
  {path: '', component: LandingComponent},

  // Rutas para el administrador
  {
    path: 'administrador',
    component: AdministradorComponent,
    children: [
      {path: 'pacientes', component: PacienteComponent},
      {path: 'pacientes/info/:id', component: InformacionPacienteComponent},
      {path: 'pacientes/modificar/:id', component: ModificarPacienteComponent},
      {path: 'pacientes/registrar', component: RegistrarPacienteComponent},

      {path: 'clientes', component: ClienteComponent},
      {path: 'clientes/info/:id', component: InformacionClienteComponent},
      {path: 'clientes/modificar/:id', component: ModificarClienteComponent},
      {path: 'clientes/registrar', component: RegistrarClienteComponent},

      {path: 'veterinarios', component: VeterinarioComponent},
      {path: 'veterinarios/info/:id', component: InformacionVeterinarioComponent},
      {path: 'veterinarios/modificar/:id', component: ModificarVeterinarioComponent},
      {path: 'veterinarios/registrar', component: RegistrarVeterinarioComponent},

      {path: 'dashboard', component: TableroDatosAdministradorComponent},
    ]
  },

  // Rutas para el veterinario
  {
    path: 'veterinario',
    component: VeterinarioComponent,
    children: [
      {path: 'pacientes', component: PacienteComponent},
      {path: 'pacientes/info/:id', component: InformacionPacienteComponent},
      {path: 'pacientes/modificar/:id', component: ModificarPacienteComponent},
      {path: 'pacientes/registrar', component: RegistrarPacienteComponent},
      {path: 'pacientes/tratamiento/:id', component: TratamientoPacienteComponent},
      {path: 'pacientes/historial/:id', component: HistorialPacienteComponent},

      {path: 'clientes', component: ClienteComponent},
      {path: 'clientes/info/:id', component: InformacionClienteComponent},
      {path: 'clientes/modificar/:id', component: ModificarClienteComponent},
      {path: 'clientes/registrar', component: RegistrarClienteComponent}
    ]
  },


  {path: 'cliente/:id/pacientes', component: ClienteComponent},
  {path: 'test', component: TestComponentComponent},
  {path: '404', component: Error404Component},
  {path: '**', redirectTo: '/404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Importa el módulo de enrutamiento con las rutas definidas
  exports: [RouterModule] // Exporta el módulo de enrutamiento para usarlo en otros módulos
})
export class AppRoutingModule {
}
