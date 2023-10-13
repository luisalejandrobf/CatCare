import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-barra-lateral-cliente',
  templateUrl: './barra-lateral-cliente.component.html',
  styleUrls: ['./barra-lateral-cliente.component.css']
})
export class BarraLateralClienteComponent {

  @Output() registrarCliente = new EventEmitter<void>();

  registrarNuevoCliente() {
    this.registrarCliente.emit();
  }



  ngOnInit() {
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
