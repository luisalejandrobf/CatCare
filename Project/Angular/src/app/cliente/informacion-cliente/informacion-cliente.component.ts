import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {Paciente} from "../../paciente/paciente";
import {Cliente} from "../cliente";
import {ActivatedRoute} from "@angular/router";
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";

@Component({
  selector: 'app-informacion-cliente',
  templateUrl: './informacion-cliente.component.html',
  styleUrls: ['./informacion-cliente.component.css']
})
// Componente para mostrar la información detallada de un cliente.
export class InformacionClienteComponent implements OnChanges, OnInit {
// Propiedad que recibe la información del cliente desde un componente padre.
  @Input() cliente: Cliente | null = null;


  constructor(private route: ActivatedRoute, private clienteService: ClienteService, private pacienteService: PacienteService) {}

  ngOnInit() {
    const clienteIdConsulta = this.route.snapshot.params['id'];
    // Carga la información del cliente usando pacienteId
    this.clienteService.getClienteById(clienteIdConsulta).subscribe(cliente => {
      this.cliente = cliente;
      console.log('Cliente con ID', clienteIdConsulta, ':', cliente);
    });
  }

  // Detecta y maneja los cambios en la propiedad @Input del cliente.
  ngOnChanges() {
    console.log('Cliente recibido:', this.cliente);
  }


}
