import {Component, Input, EventEmitter, Output} from '@angular/core';
import {Veterinario} from '../veterinario'; // Adjust the path as needed
import {VeterinarioService} from "../../service/veterinario/veterinario.service"; // Adjust the path as needed
import {Router} from '@angular/router';

@Component({
  selector: 'app-tabla-veterinario',
  templateUrl: './tabla-veterinario.component.html',
  styleUrls: ['./tabla-veterinario.component.css']
})
export class TablaVeterinarioComponent {

  constructor(private veterinarioService: VeterinarioService, private router: Router) {
  }

  @Input() veterinarioLista: Veterinario[] = [];
  @Output() verInformacionVeterinario = new EventEmitter<Veterinario>();
  @Output() modificarVeterinario = new EventEmitter<Veterinario>();

  informacionVeterinario(veterinario: Veterinario) {
    this.router.navigate(['/administrador/veterinarios/info', veterinario.id]);
  }

  eliminarVeterinario(veterinario: Veterinario) {
    this.veterinarioService.eliminarVeterinario(veterinario.id).subscribe(response => {
      console.log('Respuesta al eliminar veterinario con ID', veterinario.id, ':', response);
      window.location.reload();
    });
  }
}
