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

  constructor(private route: ActivatedRoute, private veterinarioService: VeterinarioService) {}

  ngOnInit() {
    const veterinarioIdConsulta = this.route.snapshot.params['id'];
    // Load the veterinarian's information using veterinarioId
    this.veterinarioService.getVeterinarioById(veterinarioIdConsulta).subscribe(veterinario => {
      this.veterinario = veterinario;
      console.log('Veterinario con ID', veterinarioIdConsulta, ':', veterinario);
    });
  }

  ngOnChanges() {
    console.log('Veterinario recibido:', this.veterinario);
  }
}
