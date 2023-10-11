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
}
