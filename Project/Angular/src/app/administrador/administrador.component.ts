import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-administrador',
  templateUrl: './administrador.component.html',
  styleUrls: ['./administrador.component.css']
})
export class AdministradorComponent implements OnInit {
  vista: 'pacientes' | 'clientes' | 'veterinarios' = 'pacientes';


  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
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
