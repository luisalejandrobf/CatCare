import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {Paciente} from "../../paciente/paciente";
import {Cliente} from "../cliente";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-tabla-cliente',
  templateUrl: './tabla-cliente.component.html',
  styleUrls: ['./tabla-cliente.component.css']
})
// Componente para manejar y mostrar una tabla de clientes.
export class TablaClienteComponent implements OnInit{

  // Variable para controlar la vista actual.
  vista!: string;

  constructor(private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router, private route: ActivatedRoute) {
  }
  // Lista de clientes para mostrar, recibida desde un componente padre.
  @Input() clienteLista: Cliente[] = [];
  @Output() verInformacionCliente = new EventEmitter<Cliente>();
  @Output() modificarCliente = new EventEmitter<Cliente>();


  ngOnInit(): void {
    // Obtiene la URL completa
    const fullPath = this.router.url;
    // Divide la URL por '/' y toma el primer segmento
    this.vista = fullPath.split('/')[1];
    console.log("Valor de vista:", this.vista);
  }

  // Método para eliminar un cliente de la lista
  eliminarClientes(cliente: Cliente) {
    this.clienteService.eliminarCliente(cliente.id).subscribe(response => {
      console.log('Respuesta al eliminar cliente con ID', cliente.id, ':', response);
      window.location.reload();
    });
  }

  // Método para filtrar la tabla de clientes por cédula.
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
