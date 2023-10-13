import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-barra-lateral-paciente',
  templateUrl: './barra-lateral-paciente.component.html',
  styleUrls: ['./barra-lateral-paciente.component.css']
})
export class BarraLateralPacienteComponent {
  @Output() registrarPaciente = new EventEmitter<void>();

  registrarNuevoPaciente() {
    this.registrarPaciente.emit();
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
