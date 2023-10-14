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


  eliminarVeterinario(veterinario: Veterinario) {
    this.veterinarioService.eliminarVeterinario(veterinario.id).subscribe(response => {
      console.log('Respuesta al eliminar veterinario con ID', veterinario.id, ':', response);
      window.location.reload();
    });
  }

  // Filtrar por cedula
  filterTable(): void {
    let input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("nameFilter") as HTMLInputElement;
    filter = input.value.toUpperCase();
    table = document.getElementById("patientTable");
    tr = table?.getElementsByTagName("tr");

    if (tr) {
      for (i = 1; i < tr.length; i++) {
        td = tr[i]?.getElementsByTagName("td")[1];

        if (td) {
          txtValue = td.textContent || td.innerText;

          if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }
      }
    }
  }
}
