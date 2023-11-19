import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/service/cliente/cliente.service';

@Component({
  selector: 'app-barra-superior-cliente',
  templateUrl: './barra-superior-cliente.component.html',
  styleUrls: ['./barra-superior-cliente.component.css']
})
export class BarraSuperiorClienteComponent {

  constructor( private clienteService: ClienteService, private router: Router ) {}

  ngOnInit() {

    console.log("BarraSuperiorClienteComponent")

    this.clienteService.clienteHome().subscribe(
      (response) => {
        console.error('Auth permission for ClienteHome');

      },
      (error) => {
        console.error('No Auth permission for ClienteHome', error);
        this.router.navigate(['']); // Redireccionar
      }
    );

  }

}
