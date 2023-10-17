import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Veterinario} from "../veterinario";
import {ActivatedRoute, Router} from "@angular/router";
import {VeterinarioService} from "../../service/veterinario/veterinario.service";

@Component({
  selector: 'app-modificar-veterinario',
  templateUrl: './modificar-veterinario.component.html',
  styleUrls: ['./modificar-veterinario.component.css']
})
export class ModificarVeterinarioComponent implements OnInit{

  @Input() veterinario: Veterinario | null = null;
  @Output() veterinarioModificado = new EventEmitter<Veterinario>();

  // Inyección de dependencias del servicio, ruta activa y enrutador.
  constructor(private route: ActivatedRoute, private veterinarioService: VeterinarioService, private router: Router) {}

  ngOnInit() {
    const veterinarioId = this.route.snapshot.params['id'];

    // Obtener el veterinario por ID
    this.veterinarioService.getVeterinarioById(veterinarioId).subscribe(veterinario => {
      this.veterinario = veterinario;
      console.log('Veterinario a modificar:', this.veterinario);
    });
  }

  // Método que maneja el envío del formulario de actualización del veterinario.
  enviarFormulario(form: any) {
    if (this.veterinario && form.valid) {
      const veterinarioActualizado: Veterinario = this.veterinario;
      this.veterinarioService.actualizarVeterinario(veterinarioActualizado.id, veterinarioActualizado).subscribe(response => {
        console.log('Veterinario actualizado:', response);
        // Emitir el evento para notificar que el veterinario ha sido modificado
        this.veterinarioModificado.emit(veterinarioActualizado);

        // Redirigir al usuario a la tabla de veterinarios
        this.router.navigate(['/administrador/veterinarios']);
      });
    }
  }
}
