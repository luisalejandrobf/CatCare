package com.catcare.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Service.TratamientoService;
import com.catcare.project.Service.TratamientoServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/catcare/tratamientos")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class TratamientoController {

    @Autowired
    TratamientoService tratamientoService;

    // Envía la lista de tratamientos desde tratamientoService a Thymeleaf para que
    // el HTML pueda acceder a ella.
    // http://localhost:8090/catcare/tratamientos/all
    @GetMapping("/all")
    @Operation(summary = "Devuelve todos los tratamientos")
    public List<Tratamiento> mostrarTratamientos() {
        return (List<Tratamiento>) tratamientoService.SearchAll();
    }

    // http://localhost:8090/catcare/tratamientos/find?id=1
    @GetMapping("/find")
    @Operation(summary = "Devuelve un tratamiento")
    public Tratamiento mostrarInfoTratamiento(@RequestParam("id") Long id) {

        // Busca un tratamiento por su ID utilizando el servicio tratamientoService
        Tratamiento tratamiento = tratamientoService.SearchById(id);

        if (tratamiento != null) {
            // Verifica si se encontró el tratamiento
        } else {
            // Si no se encontró el dr, retornar vacio
            tratamiento = new Tratamiento();
        }

        return tratamiento;
    }

    // El metodo para agregar solo envia a la pagina, se deja unicamente el post.
    // http://localhost:8090/catcare/tratamientos/agregar
    @PostMapping("/agregar")
    @Operation(summary = "Agrega un tratamiento")
    public void agregarTratamiento(@RequestBody Tratamiento tratamiento) {
        // Llama al servicio tratamientoService para agregar el tratamiento a la base de
        // datos
        tratamientoService.add(tratamiento);
    }

    // http://localhost:8090/catcare/tratamientos/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina un tratamiento")
    public void eliminarTratamiento(@PathVariable("id") Long id) {
        // Llama al servicio tratamientoService para eliminar el tratamiento con el ID
        // especificado
        tratamientoService.deleteById(id);
    }

    // El metodo para actualizar solo envia a la pagina, se deja unicamente el post.
    // Post para Update del tratamiento. Se accede con el ID del tratamiento.
    // http://localhost:8090/catcare/tratamientos/update/1
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualiza un tratamiento")
    public void actualizarTratamiento(@PathVariable("id") Long id, @RequestBody Tratamiento tratamiento) {
        // Llama al servicio tratamientoService para actualizar los datos del
        // tratamiento con el ID especificado
        tratamientoService.update(tratamiento);
    }

    
    // Consultas

    // http://localhost:8090/catcare/tratamientos/tratamientosEnElUltimoMes
    @GetMapping("/tratamientosEnElUltimoMes")
    @Operation(summary = "Devuelve la cantidad de tratamientos administrados en el último mes")
    public Long tratamientosEnElUltimoMes() {
    return tratamientoService.countTratamientosLastMonth();
    }

    // http://localhost:8090/catcare/tratamientos/mascotasActivas
    @GetMapping("/mascotasActivas")
    @Operation(summary = "Devuelve la cantidad de mascotas activas (En tratamiento)")
    public Long mascotasActivas() {
    return tratamientoService.countMascotasEnTratamiento();
    }

}
