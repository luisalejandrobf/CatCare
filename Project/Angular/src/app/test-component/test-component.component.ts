import { Component } from '@angular/core';
import { ClienteService } from '../service/cliente/cliente.service';
import { PacienteService } from '../service/paciente/paciente.service';
import { AdministradorService } from '../service/administrador/administrador.service';
import { DrogaService } from '../service/droga/droga.service';
import { TratamientoService } from '../service/tratamiento/tratamiento.service';
import { VeterinarioService } from '../service/veterinario/veterinario.service';


@Component({
  selector: 'app-test-component',
  templateUrl: './test-component.component.html',
  styleUrls: ['./test-component.component.css']
})
export class TestComponentComponent {

  constructor(
    private clienteService: ClienteService,
    private pacienteService: PacienteService,
    private veterinarioService: VeterinarioService,
    private administradorService: AdministradorService,
    private drogaService: DrogaService,
    private tratamientoService: TratamientoService
  ) { }

  clienteTests() {

    // Llamadas a métodos del servicio ClienteService

    console.log("ClienteService tests")

    // Obtener todos los clientes
    this.clienteService.getAllClientes().subscribe(clientes => {
      console.log('Clientes:', clientes);
    });

    // Obtener pacientes de un cliente específico
    const clienteId = 3;
    this.clienteService.getPacientesByClienteId(clienteId).subscribe(pacientes => {
      console.log('Pacientes del cliente con ID', clienteId, ':', pacientes);
    });

    // Obtener un cliente por ID
    const clienteIdConsulta = 2;
    this.clienteService.getClienteById(clienteIdConsulta).subscribe(cliente => {
      console.log('Cliente con ID', clienteIdConsulta, ':', cliente);
    });

    // Agregar un nuevo cliente
    const nuevoCliente = {
      nombre: 'Nuevo Cliente',
      // ...otros campos del cliente
    };
    this.clienteService.agregarCliente(nuevoCliente).subscribe(response => {
      console.log('Respuesta al agregar cliente:', response);
    });

    // Eliminar un cliente por ID
    const clienteIdEliminar = 3;
    this.clienteService.eliminarCliente(clienteIdEliminar).subscribe(response => {
      console.log('Respuesta al eliminar cliente con ID', clienteIdEliminar, ':', response);
    });

    // Actualizar un cliente por ID
    const clienteIdActualizar = 4;
    const datosActualizados = { // Esto se reemplaza por el objeto cliente
      "id": 4,
      "cedula": "5132532523",
      "nombre": "Aaactualizado!!!",
      "correo": "Maria.garcia2131@hotmail.com",
      "celular": "3112345678",
      "foto": "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"
    };
    this.clienteService.actualizarCliente(clienteIdActualizar, datosActualizados).subscribe(response => {
      console.log('Respuesta al actualizar cliente con ID', clienteIdActualizar, ':', response);
    });


    // Esperar 2 segundos (2000 milisegundos)
    const tiempoEspera = 2000;

    setTimeout(() => {
      console.log('Han pasado 2 segundos...');

      // Mostrar todos los clientes
      this.clienteService.getAllClientes().subscribe(clientes => {
        console.log('Verificacion final para clientes...', clientes);
        console.log("\n\n\n\n");
      });
    }, tiempoEspera);

  }

  pacienteTests() {

    // Llamadas a métodos del servicio PacienteService

    console.log("PacienteService tests")

    // Obtener todos los pacientes
    this.pacienteService.getAllPacientes().subscribe(pacientes => {
      console.log('Pacientes:', pacientes);
    });

    // Obtener un paciente por ID
    const pacienteIdConsulta = 5;
    this.pacienteService.getPacienteById(pacienteIdConsulta).subscribe(paciente => {
      console.log('Paciente con ID', pacienteIdConsulta, ':', paciente);
    });

    // Agregar un nuevo paciente
    const nuevoPaciente = {
      nombre: 'Nuevo Paciente',
      // ...otros campos del paciente
    };
    this.pacienteService.agregarPaciente(nuevoPaciente).subscribe(response => {
      console.log('Respuesta al agregar paciente:', response);
    });

    // Eliminar un paciente por ID
    const pacienteIdEliminar = 1;
    this.pacienteService.eliminarPaciente(pacienteIdEliminar).subscribe(response => {
      console.log('Respuesta al eliminar paciente con ID', pacienteIdEliminar, ':', response);
    });

    // Actualizar un paciente por ID
    const pacienteIdActualizar = 7;
    const datosPacienteActualizados = { // Esto se reemplaza con el objeto paciente
      "id": 7,
      "nombre": "Actualizado el paciente!!",
      "raza": "Cornish Rex",
      "edad": 3,
      "peso": 15.7,
      "enfermedad": "Tos",
      "estado": "Activo",
      "foto": "https://media.ambito.com/p/e31ec80599101794839617073dc319e7/adjuntos/239/imagenes/040/456/0040456806/gatos-portadajpg.jpg",
      "cliente": {
        "id": 2,
        "cedula": "231113124523",
        "nombre": "Felipe Garcia Castiblanco",
        "correo": "felipe.gar@javeriana.edu.co",
        "celular": "32424234334",
        "foto": "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"
      }
    };

    // Llamada al método actualizarPaciente del servicio PacienteService
    this.pacienteService.actualizarPaciente(pacienteIdActualizar, datosPacienteActualizados).subscribe(response => {
      console.log('Respuesta al actualizar paciente con ID', pacienteIdActualizar, ':', response);
    });

    this.pacienteService.getTratamientosByPacienteId(1).subscribe(response => {
      console.log('Tratamientos asociados al paciente con ID 1:', response);
    });

    // Esperar 2 segundos (2000 milisegundos)
    const tiempoEspera = 2000;

    setTimeout(() => {
      console.log('Han pasado 2 segundos...');

      // Obtener todos los pacientes
      this.pacienteService.getAllPacientes().subscribe(pacientes => {
        console.log('Verificacion final para pacientes...', pacientes);
        console.log("\n\n\n\n");
      });

    }, tiempoEspera);

  }

  veterinarioTests() {

  // Llamadas a métodos del servicio VeterinarioService
  console.log("VeterinarioService tests");

  // Conseguir todos los veterinarios
  this.veterinarioService.getAllVeterinarios().subscribe(veterinarios => {
    console.log('List of veterinarios:', veterinarios);
  });

  // Conseguir veterinario por id
  const veterinarioId = 1;
  this.veterinarioService.getVeterinarioById(veterinarioId).subscribe(veterinario => {
    console.log('Veterinario with ID', veterinarioId, ':', veterinario);
  });

  // Agregar veterinario
  const nuevoVeterinario = {
    "id": 1,
    "cedula": "67890123456789",
    "nombre": "Pepito Perez",
    "contrasena": "k1l2",
    "especialidad": "Pediatría",
    "foto": "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph",
    "estado": "Activo"
  }
  ;
  this.veterinarioService.agregarVeterinario(nuevoVeterinario).subscribe(response => {
    console.log('Response after adding veteriario:', response);
  });

  // Eliminar Veterinario
  const veterinarioIdEliminar = 4;
  this.veterinarioService.eliminarVeterinario(veterinarioIdEliminar).subscribe(response => {
    console.log('Response after deleting veteriario with ID', veterinarioIdEliminar, ':', response);
  });

  const veterinarioIdActualizar = 1;
  const datosVeterinarioActualizados = {
    "cedula": "67890123456789",
    "nombre": "Epa la arepa",
    "contrasena": "k1l2",
    "especialidad": "Pediatría",
    "foto": "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-gato_23-2149100172.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph",
    "estado": "Activo"
  }
  ;

  // Actualizar veterinario
  this.veterinarioService.actualizarVeterinario(veterinarioIdActualizar, datosVeterinarioActualizados).subscribe(response => {
    console.log('Response after updating veteriario with ID', veterinarioIdActualizar, ':', response);
  });

  // Wait for 2 seconds (2000 milliseconds)
  const tiempoEspera = 2000;

  setTimeout(() => {
    console.log('2 seconds have passed...');

    this.veterinarioService.getAllVeterinarios().subscribe(veterinarios => {
      console.log('List of veterinarios:', veterinarios);
    });

  }, tiempoEspera);

  }

  administradorTests() {

    // Llamadas a métodos del servicio AdministradorService

    console.log("AdministradorService tests")

    // Todos
    this.administradorService.getAllAdministradores().subscribe(administradores => {
      console.log('Lista de administradores:', administradores);
    });

    // Conseguir admin por id
    const administradorId = 1;
    this.administradorService.getAdministradorById(administradorId).subscribe(administrador => {
      console.log('Administrador con ID', administradorId, ':', administrador);
    });

    // Agregar admin
    const nuevoAdministrador =
    {
      usuario: "AdministradorAgregado",
      contrasena: "1234"
    };
    this.administradorService.agregarAdministrador(nuevoAdministrador).subscribe(response => {
      console.log('Respuesta al agregar administrador:', response);
    });

    // Eliminar admin
    const administradorIdEliminar = 4;
    this.administradorService.eliminarAdministrador(administradorIdEliminar).subscribe(response => {
      console.log('Respuesta al eliminar administrador con ID', administradorIdEliminar, ':', response);
    });

    // Actualizar admin
    const administradorIdActualizar = 1;
    const datosAdministradorActualizados =
    {
      id: "1",
      usuario: "LuisitoActualizado",
      contrasena: "1234"
    };

    this.administradorService.actualizarAdministrador(administradorIdActualizar, datosAdministradorActualizados).subscribe(response => {
      console.log('Respuesta al actualizar administrador con ID', administradorIdActualizar, ':', response);
    });


    // Esperar 2 segundos (2000 milisegundos)
    const tiempoEspera = 2000;

    setTimeout(() => {
      console.log('Han pasado 2 segundos...');

      // Todos
      this.administradorService.getAllAdministradores().subscribe(administradores => {
        console.log('Lista de administradores:', administradores);
        console.log("\n\n\n\n");
      });

    }, tiempoEspera);

  }

  drogatests() {

    // Llamadas a métodos del servicio DrogaService
    console.log("DrogaService tests");

    // Obtener todas las drogas
    this.drogaService.getAllDrogas().subscribe(drogas => {
      console.log('Lista de drogas:', drogas);
    });

    // Obtener droga por id
    const drogaId = 1;
    this.drogaService.getDrogaById(drogaId).subscribe(droga => {
      console.log('Droga con ID', drogaId, ':', droga);
    });

    // Agregar droga
    const nuevaDroga = {
      nombre: "DROGADEPRUEBAAAAA",
      precioVenta: 151300,
      precioCompra: 60520,
      unidadesDisponibles: 4,
      unidadesVendidas: 0
    };
    this.drogaService.agregarDroga(nuevaDroga).subscribe(response => {
      console.log('Respuesta al agregar droga:', response);
    });

    // Eliminar droga
    const drogaIdEliminar = 4;
    this.drogaService.eliminarDroga(drogaIdEliminar).subscribe(response => {
      console.log('Respuesta al eliminar droga con ID', drogaIdEliminar, ':', response);
    });

    // Actualizar droga
    const drogaIdActualizar = 1;
    const datosDrogaActualizados = {
      "id": 1,
      "nombre": "DROGAACTUALIZADAAA",
      "precioVenta": 151300,
      "precioCompra": 60520,
      "unidadesDisponibles": 4,
      "unidadesVendidas": 0
    }
    this.drogaService.actualizarDroga(drogaIdActualizar, datosDrogaActualizados).subscribe(response => {
      console.log('Respuesta al actualizar droga con ID', drogaIdActualizar, ':', response);
    });

    // Esperar 2 segundos (2000 milisegundos)
    const tiempoEspera = 2000;

    setTimeout(() => {
      console.log('Han pasado 2 segundos...');

      // Obtener todas las drogas
      this.drogaService.getAllDrogas().subscribe(drogas => {
        console.log('Lista de drogas:', drogas);
        console.log("\n\n\n\n");
      });

    }, tiempoEspera);

  }

  tratamientoTests() {

    // Llamadas a métodos del servicio TratamientoService
    console.log("TratamientoService tests");

    // Obtener todos los tratamientos
    this.tratamientoService.getAllTratamientos().subscribe(tratamientos => {
      console.log('Lista de tratamientos:', tratamientos);
    });

    // Obtener tratamiento por id
    const tratamientoId = 1;
    this.tratamientoService.getTratamientoById(tratamientoId).subscribe(tratamiento => {
      console.log('Tratamiento con ID', tratamientoId, ':', tratamiento);
    });

    // Agregar tratamiento
    const nuevoTratamiento =
    {
      "fechaDeInicio": "2023-10-14",
      "paciente": {
        "id": 5,
        "nombre": "Cooper",
        "raza": "Ragdoll ",
        "edad": 5,
        "peso": 10.2,
        "enfermedad": "Gripe",
        "estado": "Activo",
        "foto": "https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png",
        "cliente": {
          "id": 2,
          "cedula": "231113124523",
          "nombre": "Felipe Garcia Castiblanco",
          "correo": "felipe.gar@javeriana.edu.co",
          "celular": "32424234334",
          "foto": "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"
        }
      },
      "droga": {
        "id": 294,
        "nombre": "MARBOCOLI",
        "precioVenta": 61900,
        "precioCompra": 24760,
        "unidadesDisponibles": 10,
        "unidadesVendidas": 0
      },
      "veterinario": {
        "id": 45,
        "cedula": "01234567890123",
        "nombre": "Zulma Yaneth Ortiz",
        "contrasena": "a2b3",
        "especialidad": "Nefrología",
        "foto": "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph",
        "estado": "Activo"
      }
    };
    this.tratamientoService.agregarTratamiento(nuevoTratamiento).subscribe(response => {
      console.log('Respuesta al agregar tratamiento:', response);
    });

    // Eliminar tratamiento
    const tratamientoIdEliminar = 4;
    this.tratamientoService.eliminarTratamiento(tratamientoIdEliminar).subscribe(response => {
      console.log('Respuesta al eliminar tratamiento con ID', tratamientoIdEliminar, ':', response);
    });

    // Actualizar tratamiento
    const tratamientoIdActualizar = 1;
    const datosTratamientoActualizados = {
      "fechaDeInicio": "2023-10-18",
      "paciente": {
        "id": 5,
        "nombre": "Cooper",
        "raza": "Ragdoll ",
        "edad": 5,
        "peso": 10.2,
        "enfermedad": "Gripe",
        "estado": "Activo",
        "foto": "https://nupec.com/wp-content/uploads/2021/02/Captura-de-pantalla-2021-02-08-a-las-13.59.48.png",
        "cliente": {
          "id": 2,
          "cedula": "231113124523",
          "nombre": "Felipe Garcia Castiblanco",
          "correo": "felipe.gar@javeriana.edu.co",
          "celular": "32424234334",
          "foto": "https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVyc29uYXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80"
        }
      },
      "droga": {
        "id": 294,
        "nombre": "MARBOCOLI",
        "precioVenta": 61900,
        "precioCompra": 24760,
        "unidadesDisponibles": 10,
        "unidadesVendidas": 0
      },
      "veterinario": {
        "id": 45,
        "cedula": "01234567890123",
        "nombre": "Zulma Yaneth Ortiz",
        "contrasena": "a2b3",
        "especialidad": "Nefrología",
        "foto": "https://img.freepik.com/foto-gratis/cerca-veterinario-cuidando-mascota_23-2149143894.jpg?size=626&ext=jpg&ga=GA1.1.42545629.1693093912&semt=sph",
        "estado": "Activo"
      }
    };

    this.tratamientoService.actualizarTratamiento(tratamientoIdActualizar, datosTratamientoActualizados).subscribe(response => {
      console.log('Respuesta al actualizar tratamiento con ID', tratamientoIdActualizar, ':', response);
    });

    // Esperar 2 segundos (2000 milisegundos)
    const tiempoEspera = 2000;

    setTimeout(() => {
      console.log('Han pasado 2 segundos...');

      // Obtener todos los tratamientos
      this.tratamientoService.getAllTratamientos().subscribe(tratamientos => {
        console.log('Lista de tratamientos:', tratamientos);
      });

    }, tiempoEspera);

  }


}
