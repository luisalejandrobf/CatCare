import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {LandingComponent} from "./landing/landing.component";
import {AdministradorComponent} from "./administrador/administrador.component";
import {TestComponentComponent} from "./test-component/test-component.component";
import {VeterinarioComponent} from "./veterinario/veterinario.component";
import {ClienteComponent} from "./cliente/cliente.component";


// Define las rutas de la aplicación
const routes: Routes = [
  // Ruta raíz (ruta del landing page)
  {path: '', component: LandingComponent},

  // Ruta para llevar a pagina  principal de administrador
  // Componente principal para la ruta 'administrador'
  {path: 'administrador/pacientes', component: AdministradorComponent},
  {path: 'administrador/clientes', component: AdministradorComponent},
  {path: 'administrador/veterinarios', component: AdministradorComponent},

  {path: 'veterinario/pacientes', component: VeterinarioComponent},
  {path: 'veterinario/clientes', component: VeterinarioComponent},

  {path: 'cliente/pacientes', component: ClienteComponent},

  {path: 'test', component: TestComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Importa el módulo de enrutamiento con las rutas definidas
  exports: [RouterModule] // Exporta el módulo de enrutamiento para usarlo en otros módulos
})
export class AppRoutingModule { }
