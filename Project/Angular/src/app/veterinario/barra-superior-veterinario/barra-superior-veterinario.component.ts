import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { VeterinarioService } from 'src/app/service/veterinario/veterinario.service';

@Component({
  selector: 'app-barra-superior-veterinario',
  templateUrl: './barra-superior-veterinario.component.html',
  styleUrls: ['./barra-superior-veterinario.component.css']
})
export class BarraSuperiorVeterinarioComponent {

  constructor( private veterinarioService: VeterinarioService, private router: Router ) {}

  ngOnInit() {

    console.log("BarraSuperiorVeterinarioComponent")

    this.veterinarioService.veterinarioHome().subscribe(
      (response) => {
        console.error('Auth permission for VeterinarioHome');

      },
      (error) => {
        console.error('No Auth permission for VeterinarioHome', error);
        this.router.navigate(['']); // Redireccionar
      }
    );

  }
  
}
