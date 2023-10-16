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

  vista!: string;


  @Input() paciente: Paciente | null = null;
  @Output() pacienteModificado = new EventEmitter<Paciente>();

  constructor(private route: ActivatedRoute, private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router) {}

  ngOnInit() {
    // Obtiene la URL completa
    const fullPath = this.router.url;
    // Divide la URL por '/' y toma el primer segmento
    this.vista = fullPath.split('/')[1];

    const pacienteId = this.route.snapshot.params['id'];

    // Obtener el paciente por ID
    this.pacienteService.getPacienteById(pacienteId).subscribe(paciente => {
      this.paciente = paciente;
      console.log('Paciente a modificar:', this.paciente);
    });
  }

  enviarFormulario(form: any) {
    if (this.paciente && form.valid) {
      const pacienteActualizado: Paciente = this.paciente;
      this.pacienteService.actualizarPaciente(pacienteActualizado.id, pacienteActualizado).subscribe(response => {
        console.log('Paciente actualizado:', response);
        // Emitir el evento para notificar que el paciente ha sido modificado
        this.pacienteModificado.emit(pacienteActualizado);

        // Verificar el valor de vista y redirigir al usuario a la ruta correspondiente
        if (this.vista === 'administrador') {
          // Redirigir al usuario a la tabla de pacientes de un administrador
          this.router.navigate(['/administrador/pacientes']);
        } else if (this.vista === 'veterinario') {
          // Redirigir al usuario a la tabla de pacientes de un veterinario
          this.router.navigate(['/veterinario/pacientes']);
        }
      });
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }


}
