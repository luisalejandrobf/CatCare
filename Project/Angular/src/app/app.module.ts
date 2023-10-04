import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LandingComponent } from './landing/landing.component';
import { PacienteComponent } from './paciente/paciente.component';
import { ClienteComponent } from './cliente/cliente.component';
import { VeterinarioComponent } from './veterinario/veterinario.component';
import { TablaPacienteComponent } from './paciente/tabla-paciente/tabla-paciente.component';
import { BarraLateralPacienteComponent } from './paciente/barra-lateral-paciente/barra-lateral-paciente.component';
import { BarraSuperiorPacienteComponent } from './paciente/barra-superior-paciente/barra-superior-paciente.component';
import {RouterOutlet} from "@angular/router";
import { FormularioRegistroPacienteComponent } from './paciente/formulario-registro-paciente/formulario-registro-paciente.component';
import { InformacionPacienteComponent } from './paciente/informacion-paciente/informacion-paciente.component';
import {FormsModule} from "@angular/forms";
import { ModificarPacienteComponent } from './paciente/modificar-paciente/modificar-paciente.component';
import { DrogaComponent } from './droga/droga.component';
import { TratamientoComponent } from './tratamiento/tratamiento.component';
import { AdministradorComponent } from './administrador/administrador.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    PacienteComponent,
    ClienteComponent,
    VeterinarioComponent,
    TablaPacienteComponent,
    BarraLateralPacienteComponent,
    BarraSuperiorPacienteComponent,
    FormularioRegistroPacienteComponent,
    InformacionPacienteComponent,
    ModificarPacienteComponent,
    DrogaComponent,
    TratamientoComponent,
    AdministradorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
