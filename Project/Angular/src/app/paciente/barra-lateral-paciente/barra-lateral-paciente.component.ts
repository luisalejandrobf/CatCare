import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-barra-lateral-paciente',
  templateUrl: './barra-lateral-paciente.component.html',
  styleUrls: ['./barra-lateral-paciente.component.css']
})
export class BarraLateralPacienteComponent implements OnInit{

  vista!: string;

  @Output() registrarPaciente = new EventEmitter<void>();

  // Constructor del componente donde se inyectan servicios y se inicializan variables.
  constructor(private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router, private route: ActivatedRoute) {
  }

  // Método para emitir el evento 'registrarPaciente', que se activará al llamar este método.
  registrarNuevoPaciente() {
    this.registrarPaciente.emit();
  }

  // Ciclo de vida 'OnInit' que se ejecuta después del constructor y luego de recibir las propiedades 'input'.
  ngOnInit() {
    // Obtiene la URL completa
    const fullPath = this.router.url;
    // Divide la URL por '/' y toma el primer segmento
    this.vista = fullPath.split('/')[1];
    console.log("Valor de vista:", this.vista);

    this.checkWindowSize();
  }

  // Método que maneja la apertura y cierre del menú lateral.
  openCloseMenu() {
    const body = document.getElementById("body-barra-lateral");
    const side_menu = document.getElementById("menu_side");
    body?.classList.toggle("body_move");
    side_menu?.classList.toggle("menu__side_move");
  }

  // Método que verifica el tamaño de la ventana y ajusta clases CSS si es menor a un cierto breakpoint.
  checkWindowSize() {
    const body = document.getElementById("body-barra-lateral");
    const side_menu = document.getElementById("menu_side");
    if (window.innerWidth < 760) {
      body?.classList.add("body_move");
      side_menu?.classList.add("menu__side_move");
    }
  }

}
