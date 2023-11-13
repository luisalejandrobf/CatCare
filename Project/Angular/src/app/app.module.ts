import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LandingComponent } from './landing/landing.component';
import { PacienteComponent } from './paciente/paciente.component';
import { ClienteComponent } from './cliente/cliente.component';
import { VeterinarioComponent } from './veterinario/veterinario.component';
import { TablaPacienteComponent } from './paciente/tabla-paciente/tabla-paciente.component';
import { InformacionPacienteComponent } from './paciente/informacion-paciente/informacion-paciente.component';
import { DrogaComponent } from './droga/droga.component';
import { TratamientoComponent } from './tratamiento/tratamiento.component';
import { AdministradorComponent } from './administrador/administrador.component';
import { TestComponentComponent } from './test-component/test-component.component';
import { FooterComponent } from './footer/footer.component';
import { BarraSuperiorAdministradorComponent } from './administrador/barra-superior-administrador/barra-superior-administrador.component';
import { ModificarPacienteComponent } from './paciente/modificar-paciente/modificar-paciente.component';
import { RegistrarPacienteComponent } from './paciente/registrar-paciente/registrar-paciente.component';
import { BarraLateralPacienteComponent } from './paciente/barra-lateral-paciente/barra-lateral-paciente.component';
import { BarraSuperiorClienteComponent } from './cliente/barra-superior-cliente/barra-superior-cliente.component';
import { InformacionClienteComponent } from './cliente/informacion-cliente/informacion-cliente.component';
import { BarraLateralClienteComponent } from './cliente/barra-lateral-cliente/barra-lateral-cliente.component';
import { ModificarClienteComponent } from './cliente/modificar-cliente/modificar-cliente.component';
import { RegistrarClienteComponent } from './cliente/registrar-cliente/registrar-cliente.component';
import { TablaClienteComponent } from './cliente/tabla-cliente/tabla-cliente.component';
import { TablaPacienteClienteComponent } from './cliente/tabla-paciente-cliente/tabla-paciente-cliente.component';
import { BarraSuperiorVeterinarioComponent } from './veterinario/barra-superior-veterinario/barra-superior-veterinario.component';
import { InformacionVeterinarioComponent } from './veterinario/informacion-veterinario/informacion-veterinario.component';
import { TablaVeterinarioComponent } from './veterinario/tabla-veterinario/tabla-veterinario.component';
import { ModificarVeterinarioComponent } from './veterinario/modificar-veterinario/modificar-veterinario.component';
import { RegistrarVeterinarioComponent } from './veterinario/registrar-veterinario/registrar-veterinario.component';
import { BarraLateralVeterinarioComponent } from './veterinario/barra-lateral-veterinario/barra-lateral-veterinario.component';
import { TableroDatosAdministradorComponent } from './administrador/tablero-datos-administrador/tablero-datos-administrador.component';
import { TratamientoPacienteComponent } from './paciente/tratamiento-paciente/tratamiento-paciente.component';
import { HistorialPacienteComponent } from './paciente/historial-paciente/historial-paciente.component';
import { Error404Component } from './error/error404/error404.component';
import {AuthInterceptor} from "./helpers/auth.interceptor";

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    PacienteComponent,
    ClienteComponent,
    VeterinarioComponent,
    TablaPacienteComponent,
    InformacionPacienteComponent,
    DrogaComponent,
    TratamientoComponent,
    AdministradorComponent,
    TestComponentComponent,
    FooterComponent,
    BarraSuperiorAdministradorComponent,
    ModificarPacienteComponent,
    RegistrarPacienteComponent,
    BarraLateralPacienteComponent,
    BarraSuperiorClienteComponent,
    InformacionClienteComponent,
    BarraLateralClienteComponent,
    ModificarClienteComponent,
    RegistrarClienteComponent,
    TablaClienteComponent,
    TablaPacienteClienteComponent,
    BarraSuperiorVeterinarioComponent,
    InformacionVeterinarioComponent,
    TablaVeterinarioComponent,
    ModificarVeterinarioComponent,
    RegistrarVeterinarioComponent,
    BarraLateralVeterinarioComponent,
    TableroDatosAdministradorComponent,
    TratamientoPacienteComponent,
    HistorialPacienteComponent,
    Error404Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
