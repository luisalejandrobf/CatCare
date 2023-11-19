import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdministradorService } from 'src/app/service/administrador/administrador.service';

@Component({
  selector: 'app-barra-superior-administrador',
  templateUrl: './barra-superior-administrador.component.html',
  styleUrls: ['./barra-superior-administrador.component.css']
})
export class BarraSuperiorAdministradorComponent {

  constructor(private administradorService: AdministradorService, private router: Router) { }

  ngOnInit() {

    console.log("BarraSuperiorAdministradorComponent")

    this.administradorService.administradorHome().subscribe(
      (response) => {
        console.error('Auth permission for AdminHome');
      },
      (error) => {
        console.error('No Auth permission for AdminHome', error);
        this.router.navigate(['']); // Redireccionar
      }
    );

  }

}
