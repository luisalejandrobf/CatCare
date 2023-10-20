package com.catcare.project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Service.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/catcare/veterinarios")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    // Envía la lista de veterinarios desde VeterinarioService a Thymeleaf para que
    // el HTML pueda acceder a ella.
    // http://localhost:8090/catcare/veterinarios/all
    @GetMapping("/all")
    @Operation(summary = "Devuelve todos los veterinarios")
    public List<Veterinario> mostrarVeterinarios() {
        return (List<Veterinario>) veterinarioService.SearchAll();
    }

    // http://localhost:8090/catcare/veterinarios/find?id=1
    @GetMapping("/find")
    @Operation(summary = "Devuelve un veterinario")
    public Veterinario mostrarInfoVeterinarios(@RequestParam("id") Long id) {

        // Busca un veterinario por su ID utilizando el servicio veterinarioService
        Veterinario veterinario = veterinarioService.SearchById(id);

        if (veterinario != null) {
            // Verifica si se encontró el veterinario
        } else {
            // Si no se encontró el veterinario, retornar vacio
            veterinario = new Veterinario();
        }

        return veterinario;
    }

    // El metodo para agregar solo envia a la pagina, se deja unicamente el post.
    // http://localhost:8090/catcare/veterinarios/agregar
    @PostMapping("/agregar")
    @Operation(summary = "Agrega un veterinario")
    public void agregarVeterinario(@RequestBody Veterinario veterinario) {
        // Llama al servicio veterinarioService para agregar el veterinario a la base de
        // datos
        veterinarioService.add(veterinario);
    }

    // http://localhost:8090/catcare/veterinarios/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina un veterinario (Cambia su estado a inactivo)")
    public void eliminarVeterinario(@PathVariable("id") Long id) {
        // Llama al servicio veterinarioService para eliminar el veterinario con el ID especificado
        // veteriarioService.deleteById(id);

        Veterinario veterinario = veterinarioService.SearchById(id);

        // Cambia el estado del veterinario a "Inactivo"
        veterinario.setEstado("Inactivo");

        // Actualiza el veterinario en la base de datos utilizando el servicio
        veterinarioService.update(veterinario);

    }

    // El metodo para actualizar solo envia a la pagina, se deja unicamente el post.
    // Post para Update del veterinario. Se accede con el ID del Veterinario.
    // http://localhost:8090/catcare/veterinarios/update/1
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualiza un veterinario")
    public void actualizarVeterinario(@PathVariable("id") Long id, @RequestBody Veterinario veterinario) {
        // Llama al servicio veterinarioService para actualizar los datos del
        // veterinario con el ID especificado
        veterinarioService.update(veterinario);
    }

    // http://localhost:8090/catcare/veterinarios/tratamientos/1
    @GetMapping("/tratamientos/{id}")
    @Operation(summary = "Devuelve todos los tratamientos aplicados por un veterinario")
    public List<Tratamiento> mostrarTratamientosDeUnPaciente(@PathVariable("id") Long id) {
        // Busca un cliente por su ID utilizando el servicio clienteService
        Veterinario veterinario = veterinarioService.SearchById(id);

        // Verifica si se encontró el cliente
        if (veterinario != null) {
            // Si el cliente existe, obtiene la lista de pacientes (mascotas) asociados a ese cliente
            List<Tratamiento> tratamientos = veterinario.getTratamientos();

            return tratamientos;
        } else {

            // Si no se encontró el cliente, redirige a una página de error
            List<Tratamiento> tratamientos = new ArrayList<>();
            return tratamientos;
        }
    }



    // Consultas

    // http://localhost:8090/catcare/veterinarios/veterinariosActivos
    @GetMapping("/veterinariosActivos")
    @Operation(summary = "Devuelve la cantidad de veterinarios activos")
    public Long veterinariosActivos() {
    return veterinarioService.countVeterinariosActivos();
    }

    // http://localhost:8090/catcare/veterinarios/veterinariosInactivos
    @GetMapping("/veterinariosInactivos")
    @Operation(summary = "Devuelve la cantidad de veterinarios inactivos")
    public Long veterinariosInactivos() {
    return veterinarioService.countVeterinariosInactivos();
    }

}
