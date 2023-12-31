import {Component, Input, EventEmitter, Output, OnInit} from '@angular/core';
import {Paciente} from '../paciente';
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";
import {Cliente} from "../../cliente/cliente";
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-tabla-paciente',
  templateUrl: './tabla-paciente.component.html',
  styleUrls: ['./tabla-paciente.component.css']
})
export class TablaPacienteComponent implements OnInit{

// Variable para almacenar una parte de la URL actual.
  vista!: string;
  constructor(private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router, private route: ActivatedRoute) {
  }


  @Input() pacienteLista: Paciente[] = [];
  @Output() verInformacionPaciente = new EventEmitter<Paciente>();
  @Output() modificarPaciente = new EventEmitter<Paciente>();
  @Output() tratarPaciente = new EventEmitter<Paciente>();

  ngOnInit(): void {
    // Obtiene la URL completa
    const fullPath = this.router.url;
    // Divide la URL por '/' y toma el primer segmento
    this.vista = fullPath.split('/')[1];
    console.log("Valor de vista:", this.vista);
  }

  // Método para navegar a la vista de información del cliente desde administrador.
  informacionClienteAdministrador(cliente: Cliente) {
    this.router.navigate(['/administrador/clientes/info', cliente.id]);
  }


  // Método para navegar a la vista de información del cliente desde vetrinario.
  informacionClienteVeterinario(cliente: Cliente) {
    this.router.navigate(['/veterinario/clientes/info', cliente.id]);
  }

// Método para eliminar un paciente.
  eliminarPacientes(paciente: Paciente) {
    this.pacienteService.eliminarPaciente(paciente.id).subscribe(response => {
      console.log('Respuesta al eliminar paciente con ID', paciente.id, ':', response);
      window.location.reload();
    });
  }

  // Método para filtrar la tabla de pacientes por nombre.
  filterTable(): void {
    let input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("nameFilter") as HTMLInputElement;
    filter = input.value.toUpperCase();
    table = document.getElementById("patientTable");
    tr = table?.getElementsByTagName("tr");

    if (tr) {
      for (i = 1; i < tr.length; i++) { // Start from 1 to skip the table header row
        td = tr[i]?.getElementsByTagName("td")[0]; // Assuming the name is in the first column

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


