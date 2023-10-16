import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Paciente} from "../../paciente/paciente";
import {Cliente} from "../cliente";
import {ActivatedRoute, Router} from "@angular/router";
import {ClienteService} from "../../service/cliente/cliente.service";
import {PacienteService} from "../../service/paciente/paciente.service";

@Component({
  selector: 'app-modificar-cliente',
  templateUrl: './modificar-cliente.component.html',
  styleUrls: ['./modificar-cliente.component.css']
})
export class ModificarClienteComponent implements OnInit{

  vista!: string;

  @Input() cliente: Cliente | null = null;
  @Output() clienteModificado = new EventEmitter<Cliente>();

  constructor(private route: ActivatedRoute, private clienteService: ClienteService, private pacienteService: PacienteService, private router: Router) {}

  ngOnInit() {

    // Obtiene la URL completa
    const fullPath = this.router.url;
    // Divide la URL por '/' y toma el primer segmento
    this.vista = fullPath.split('/')[1];
    const clienteId = this.route.snapshot.params['id'];

    // Obtener el cliente por ID
    this.clienteService.getClienteById(clienteId).subscribe(cliente => {
      this.cliente = cliente;
      console.log('Cliente a modificar:', this.cliente);
    });
  }

  enviarFormulario() {
    if (this.cliente) {
      const clienteActualizado: Cliente = this.cliente;
      this.clienteService.actualizarCliente(clienteActualizado.id, clienteActualizado).subscribe(response => {
        console.log('Cliente actualizado:', response);
        // Emitir el evento para notificar que el cliente ha sido modificado
        this.clienteModificado.emit(clienteActualizado);

        // Verificar el valor de vista y redirigir al usuario a la ruta correspondiente
        if (this.vista === 'administrador') {
          // Redirigir al usuario a la tabla de pacientes de un administrador
          this.router.navigate(['/administrador/clientes']);
        } else if (this.vista === 'veterinario') {
          // Redirigir al usuario a la tabla de pacientes de un veterinario
          this.router.navigate(['/veterinario/clientes']);
        }
      });
    }
}

}
