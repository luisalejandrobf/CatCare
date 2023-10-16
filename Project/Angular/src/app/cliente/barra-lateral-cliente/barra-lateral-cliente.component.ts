import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-barra-lateral-cliente',
  templateUrl: './barra-lateral-cliente.component.html',
  styleUrls: ['./barra-lateral-cliente.component.css']
})
export class BarraLateralClienteComponent implements OnInit{

  vista!: string;


  @Output() registrarCliente = new EventEmitter<void>();

  constructor(private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router, private route: ActivatedRoute) {
  }

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

  openCloseMenu() {
    const body = document.getElementById("body-barra-lateral");
    const side_menu = document.getElementById("menu_side");
    body?.classList.toggle("body_move");
    side_menu?.classList.toggle("menu__side_move");
  }

  checkWindowSize() {
    const body = document.getElementById("body-barra-lateral");
    const side_menu = document.getElementById("menu_side");
    if (window.innerWidth < 760) {
      body?.classList.add("body_move");
      side_menu?.classList.add("menu__side_move");
    }
  }


}
