import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {Veterinario} from "../veterinario";
import {VeterinarioService} from "../../service/veterinario/veterinario.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-informacion-veterinario',
  templateUrl: './informacion-veterinario.component.html',
  styleUrls: ['./informacion-veterinario.component.css']
})
export class InformacionVeterinarioComponent implements OnChanges, OnInit {
  @Input() veterinario: Veterinario | null = null;

  // Constructor que inyecta el servicio 'VeterinarioService' y 'ActivatedRoute' en este componente.
  constructor(private route: ActivatedRoute, private veterinarioService: VeterinarioService) {}

  ngOnInit() {
    const veterinarioIdConsulta = this.route.snapshot.params['id'];
    // Obtiene el 'id' del veterinario de la URL actual.
    this.veterinarioService.getVeterinarioById(veterinarioIdConsulta).subscribe(veterinario => {
      this.veterinario = veterinario;
      console.log('Veterinario con ID', veterinarioIdConsulta, ':', veterinario);
    });
  }

  // Se ejecuta cuando el valor de una propiedad de entrada vinculada a datos cambia. En este caso, se activa cuando 'veterinario' cambia.
  ngOnChanges() {
    console.log('Veterinario recibido:', this.veterinario);
  }
}
