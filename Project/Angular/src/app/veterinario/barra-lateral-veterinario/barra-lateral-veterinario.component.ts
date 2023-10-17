import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-barra-lateral-veterinario',
  templateUrl: './barra-lateral-veterinario.component.html',
  styleUrls: ['./barra-lateral-veterinario.component.css']
})
export class BarraLateralVeterinarioComponent {
  // Este Output emitirá un evento hacia el componente padre cuando se invoque el método para registrar un nuevo veterinario.
  @Output() registrarVeterinario = new EventEmitter<void>();

  // Este método se utiliza para emitir el evento 'registrarVeterinario'.
  registrarNuevoVeterinario() {
    this.registrarVeterinario.emit();
  }



  ngOnInit() {
    this.checkWindowSize();
  }

  // Método que alterna las clases CSS para mostrar u ocultar el menú lateral.
  openCloseMenu() {
    const body = document.getElementById("body-barra-lateral");
    const side_menu = document.getElementById("menu_side");
    body?.classList.toggle("body_move");
    side_menu?.classList.toggle("menu__side_move");
  }

  // Método que verifica el ancho de la ventana y ajusta la visibilidad del menú lateral en consecuencia.
  checkWindowSize() {
    const body = document.getElementById("body-barra-lateral");
    const side_menu = document.getElementById("menu_side");
    if (window.innerWidth < 760) {
      body?.classList.add("body_move");
      side_menu?.classList.add("menu__side_move");
    }
  }

}
