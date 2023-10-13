import {Component, EventEmitter, Input, Output} from '@angular/core';
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {Paciente} from "../../paciente/paciente";
import {Cliente} from "../cliente";

@Component({
  selector: 'app-tabla-cliente',
  templateUrl: './tabla-cliente.component.html',
  styleUrls: ['./tabla-cliente.component.css']
})
export class TablaClienteComponent {

  constructor(private clienteService: ClienteService, private pacienteService: PacienteService) {}

  @Input() clienteLista: Cliente[] = [];
  @Output() verInformacionCliente = new EventEmitter<Cliente>();
  @Output() modificarCliente = new EventEmitter<Cliente>();


  eliminarClientes(cliente: Cliente) {
    this.clienteService.eliminarCliente(cliente.id).subscribe(response => {
      console.log('Respuesta al eliminar cliente con ID', cliente.id, ':', response);
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
