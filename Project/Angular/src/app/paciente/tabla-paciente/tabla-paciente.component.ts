import { Component, Input, EventEmitter, Output } from '@angular/core';
import { Paciente } from '../paciente';

@Component({
  selector: 'app-tabla-paciente',
  templateUrl: './tabla-paciente.component.html',
  styleUrls: ['./tabla-paciente.component.css']
})
export class TablaPacienteComponent {

  @Input() pacienteLista: Paciente[] = [ {
    nombre: 'Lucky',
    raza: 'Abisinio',
    edad: '3 años',
    peso: '30 kg',
    enfermedad: 'Dolor de Estomago',
    estado: 'En Tratamiento',
    clienteNombre: 'Felipe',
    foto:'https://okdiario.com/img/2021/04/20/curiosidades-sobre-los-gatos-domesticos.jpg'

  },
    {
      nombre: 'Bella',
      raza: 'Persa',
      edad: '5 años',
      peso: '4 kg',
      enfermedad: 'Ninguna',
      estado: 'Saludable',
      clienteNombre: 'Juan',
      foto:'https://s1.ppllstatics.com/lasprovincias/www/multimedia/202112/22/media/cortadas/gato-fotolia-k8eH-U160340519019xEE-1248x770@Las%20Provincias.jpg'

    },
    {
      nombre: 'Max',
      raza: 'Ragdoll',
      edad: '2 años',
      peso: '25 kg',
      enfermedad: 'Dermatitis',
      estado: 'En Tratamiento',
      clienteNombre: 'Laura',
      foto:'https://static.nationalgeographic.es/files/styles/image_3200/public/75552.ngsversion.1422285553360.jpg?w=1600&h=1067'

    },
    {
      nombre: 'Milo',
      raza: 'Abisinio',
      edad: '4 años',
      peso: '10 kg',
      enfermedad: 'Fiebre',
      estado: 'En Tratamiento',
      clienteNombre: 'Valentina',
      foto:'https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg'

    },
    {
      nombre: 'Coco',
      raza: 'Devon Rex',
      edad: '7 años',
      peso: '5 kg',
      enfermedad: 'Alergia',
      estado: 'En Tratamiento',
      clienteNombre: 'Pepe',
      foto:'https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg'
    }];

  @Output() verInformacionPaciente = new EventEmitter<Paciente>();

  mostrarInformacion(paciente: Paciente) {
    this.verInformacionPaciente.emit(paciente);
  }


  @Output() modificarPaciente = new EventEmitter<Paciente>();

  manejarModificar(paciente: Paciente) {
    this.modificarPaciente.emit(paciente);
  }

  eliminarPaciente(paciente: Paciente) {
    const index = this.pacienteLista.indexOf(paciente);
    if (index > -1) {
      this.pacienteLista.splice(index, 1);
    }
  }
}
