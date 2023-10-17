import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-barra-lateral-cliente',
  templateUrl: './barra-lateral-cliente.component.html',
  styleUrls: ['./barra-lateral-cliente.component.css']
})
// Componente para la barra lateral de navegación para clientes.
export class BarraLateralClienteComponent implements OnInit{
  // Variable para controlar la vista actual.
  vista!: string;

  // Evento que se emite para registrar un nuevo cliente.
  @Output() registrarCliente = new EventEmitter<void>();

  constructor(private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router, private route: ActivatedRoute) {
  }


  // Método para emitir el evento de registro de nuevo cliente.
  registrarNuevoCliente() {
    this.registrarCliente.emit();
  }



  ngOnInit() {
    // Obtiene la URL completa
    const fullPath = this.router.url;
    // Divide la URL por '/' y toma el primer segmento
    this.vista = fullPath.split('/')[1];
    console.log("Valor de vista:", this.vista);


    this.checkWindowSize();
  }

  // Método para abrir o cerrar el menú lateral.
  openCloseMenu() {
    const body = document.getElementById("body-barra-lateral");
    const side_menu = document.getElementById("menu_side");
    body?.classList.toggle("body_move");
    side_menu?.classList.toggle("menu__side_move");
  }

  // Método para verificar el tamaño de la ventana y ajustar la UI si es necesario.
  checkWindowSize() {
    const body = document.getElementById("body-barra-lateral");
    const side_menu = document.getElementById("menu_side");
    if (window.innerWidth < 760) {
      body?.classList.add("body_move");
      side_menu?.classList.add("menu__side_move");
    }
  }


}
