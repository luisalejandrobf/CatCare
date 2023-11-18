import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-administrador',
  templateUrl: './administrador.component.html',
  styleUrls: ['./administrador.component.css']
})

// Componente principal para la interfaz de administración.
export class AdministradorComponent implements OnInit {
  // Define la vista actual en la interfaz de administración.
    vista: 'pacientes' | 'clientes' | 'veterinarios' = 'pacientes';


  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    // Establece la vista basada en la URL actual.
    const currentPath = this.route.snapshot.url[1]?.path;
    if (currentPath === 'clientes') {
      this.vista = 'clientes';
    } else if (currentPath === 'veterinarios') {
      this.vista = 'veterinarios';
    } else if (currentPath === 'pacientes') {
      this.vista = 'pacientes';
    }
  }

}
