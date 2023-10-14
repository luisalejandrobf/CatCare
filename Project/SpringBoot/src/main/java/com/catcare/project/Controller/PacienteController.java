package com.catcare.project.Controller;

import com.catcare.project.Controller.Error.PacienteNotFoundException;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Service.ClienteService;
import com.catcare.project.Service.PacienteService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController // Rest controller
@RequestMapping("/catcare/pacientes")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    // http://localhost:8090/catcare/pacientes/all
    @GetMapping("/all")
    @Operation(summary = "Devuelve todos los pacientes")
    public List<Paciente> mostrarPacientes() {
        return (List<Paciente>) pacienteService.SearchAll();
    }


    // http://localhost:8090/catcare/pacientes/find?id=1
    @GetMapping("/find")
    @Operation(summary = "Devuelve un paciente")
    public Paciente mostrarInfoPacientes(@RequestParam("id") Long id) {
        // Busca un paciente por su ID utilizando el servicio pacienteService
        Paciente paciente = pacienteService.SearchById(id);

        // Verifica si se encontró el paciente
        if (paciente != null) {

        } else {
            paciente = new Paciente();
        }

        // Devuelve la vista llamada "/General/showPaciente" para mostrar la información del paciente
        return paciente;
    }


    // El metodo para agregar solo envia a la pagina, se deja unicamente el post.
    // Post para agregar Paciente
    // http://localhost:8090/catcare/pacientes/agregar
    @PostMapping("/agregar")
    @Operation(summary = "Agrega un paciente")
    public void agregarPaciente(@RequestBody Paciente paciente) {
        // Agrega el paciente recibido en el formulario al servicio pacienteService para su creación
        pacienteService.add(paciente);
    }


    //  Delete GENERAL http://localhost:8090/catcare/pacientes/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina un paciente (Cambia su estado a inactivo)")
    public void eliminarPaciente(@PathVariable("id") Long id) {
        // Opción 1: Borrado total
        // pacienteService.deleteById(id);

        // Opción 2: Cambia el estado por "Inactivo"
        // Busca al paciente por su ID utilizando el servicio pacienteService
        Paciente paciente = pacienteService.SearchById(id);

        // Cambia el estado del paciente a "Inactivo"
        paciente.setEstado("Inactivo");

        // Actualiza el paciente en la base de datos utilizando el servicio pacienteService
        pacienteService.update(paciente);
    }


    // Post para Update del paciente. Se accede con el ID del Paciente.
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualiza un paciente")
    public void actualizarPaciente(@PathVariable("id") Long id, @RequestBody Paciente paciente) {
        // Actualiza el paciente con los datos recibidos del formulario utilizando el servicio pacienteService
        pacienteService.update(paciente);
    }

    // http://localhost:8090/catcare/pacientes/tratamientos/1
    @GetMapping("/tratamientos/{id}")
    @Operation(summary = "Devuelve todos los tratamientos de un paciente")
    public List<Tratamiento> mostrarTratamientosDeUnPaciente(@PathVariable("id") Long id) {
        // Busca un cliente por su ID utilizando el servicio clienteService
        Paciente paciente = pacienteService.SearchById(id);

        // Verifica si se encontró el cliente
        if (paciente != null) {
            // Si el cliente existe, obtiene la lista de pacientes (mascotas) asociados a ese cliente
            List<Tratamiento> tratamientos = paciente.getTratamientos();

            return tratamientos;
        } else {

            // Si no se encontró el cliente, redirige a una página de error
            List<Tratamiento> tratamientos = new ArrayList<>();
            return tratamientos;
        }
    }


    // ESTANDO EN UN Cliente (Regresa a la URL de visualizacion de las mascotas del cliente)

    // Metodo para encontrar mascota de cliente
    // Redireccion a showPacienteDeUnCliente
    /* Se debe implementar la redireccion en angular, despues de visualizar.
    @GetMapping("/mostrar/{clienteid}/{id}")
    @Operation(summary = "Devuelve el paciente asociado a un cliente")
    public Paciente mostrarInfoPacienteDeUnCliente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid) {
        // Busca al paciente por su ID utilizando el servicio pacienteService
        Paciente paciente = pacienteService.SearchById(id);

        // Devuelve la vista llamada "/Cliente/showPacienteDeUnCliente" que muestra la información del paciente de un cliente específico
        return "/Cliente/showPacienteDeUnCliente";
    }
    */

    // Post para Update del cliente. Se accede con el ID del Paciente.
    /* Se debe implementar la redireccion en angular, despues de actualizar.
    @PutMapping("/update/{clienteid}/{id}")
    @Operation(summary = "Actualiza un paciente, desde la vista de un cliente")
    public void actualizarPacienteDeUnCliente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid, @RequestBody Paciente paciente) {
        // Actualiza el paciente con los datos recibidos del formulario utilizando el servicio pacienteService
        pacienteService.update(paciente);

        // Redirige al usuario de vuelta a la página de visualización de las mascotas del cliente después de la actualización
        // return "redirect:/catcare/clientes/mascotas/{clienteid}";
    }
    */

    // DELETE http://localhost:8090/catcare/pacientes/delete/1
    /* Se debe implementar la redireccion en angular, despues de borrar.
    @DeleteMapping("/delete/{clienteid}/{id}")
    @Operation(summary = "Elimina un paciente, desde la vista de un cliente")
    public void eliminarPaciente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid) {
        // Elimina el paciente con el ID proporcionado utilizando el servicio pacienteService
        pacienteService.deleteById(id);

        // Después de eliminar el paciente, redirige al usuario de vuelta a la página de visualización de mascotas del cliente
        // return "redirect:/catcare/clientes/mascotas/{clienteid}";
    }
    */
}
