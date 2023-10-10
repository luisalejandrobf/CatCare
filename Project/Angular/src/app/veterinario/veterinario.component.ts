import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-veterinario',
  templateUrl: './veterinario.component.html',
  styleUrls: ['./veterinario.component.css']
})
export class VeterinarioComponent {

  vista: 'pacientes' | 'clientes' | 'veterinarios' = 'pacientes';

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    const currentPath = this.route.snapshot.url[1]?.path;
    if (currentPath === 'clientes') {
      this.vista = 'clientes';
    } else if (currentPath === 'veterinarios') {
      this.vista = 'veterinarios';
    }
  }

}
