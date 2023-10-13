import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-barra-lateral-veterinario',
  templateUrl: './barra-lateral-veterinario.component.html',
  styleUrls: ['./barra-lateral-veterinario.component.css']
})
export class BarraLateralVeterinarioComponent {
  @Output() registrarVeterinario = new EventEmitter<void>();
  
  registrarNuevoVeterinario() {
    this.registrarVeterinario.emit();
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
