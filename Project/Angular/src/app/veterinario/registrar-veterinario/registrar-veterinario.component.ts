import { Component, EventEmitter, Output } from '@angular/core';
import { Veterinario } from "../veterinario";
import { Router } from "@angular/router";
import { VeterinarioService } from "../../service/veterinario/veterinario.service";

@Component({
  selector: 'app-registrar-veterinario',
  templateUrl: './registrar-veterinario.component.html',
  styleUrls: ['./registrar-veterinario.component.css']
})
export class RegistrarVeterinarioComponent {

  @Output() veterinarioRegistrado = new EventEmitter<Veterinario>();

  constructor(private router: Router, private veterinarioService: VeterinarioService) { }

  veterinario: Veterinario = {
    id: 0,
    cedula: '',
    nombre: '',
    contrasena: '',
    especialidad: '',
    foto: ''
  };

  onSubmit(form: any) {
    if (form.valid) {
      this.veterinarioService.agregarVeterinario(this.veterinario).subscribe((response: any) => {
        console.log('Respuesta al agregar veterinario:', response);
        this.router.navigate(['/administrador/veterinarios']); // Redirige a la vista de la tabla de veterinarios
      });
    } else {
      alert('Por favor, completa el formulario correctamente.');
    }
  }

}
