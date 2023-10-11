import {Component, EventEmitter, Input, OnChanges, OnInit, Output} from '@angular/core';
import {Paciente} from "../paciente";
import {ActivatedRoute, Router} from "@angular/router";
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";

@Component({
  selector: 'app-modificar-paciente',
  templateUrl: './modificar-paciente.component.html',
  styleUrls: ['./modificar-paciente.component.css']
})
export class ModificarPacienteComponent implements OnInit{

  @Input() paciente: Paciente | null = null;
  @Output() pacienteModificado = new EventEmitter<Paciente>();

  constructor(private route: ActivatedRoute, private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router) {}

  ngOnInit() {
    const pacienteId = this.route.snapshot.params['id'];

    // Obtener el paciente por ID
    this.pacienteService.getPacienteById(pacienteId).subscribe(paciente => {
      this.paciente = paciente;
      console.log('Paciente a modificar:', this.paciente);
    });
  }

  enviarFormulario() {
    if (this.paciente) {
      const pacienteActualizado: Paciente = this.paciente;
      this.pacienteService.actualizarPaciente(pacienteActualizado.id, pacienteActualizado).subscribe(response => {
        console.log('Paciente actualizado:', response);
        // Emitir el evento para notificar que el paciente ha sido modificado
        this.pacienteModificado.emit(pacienteActualizado);

        // Redirigir al usuario a la tabla de pacientes
        this.router.navigate(['/administrador/pacientes']);
      });
    }
  }


}
