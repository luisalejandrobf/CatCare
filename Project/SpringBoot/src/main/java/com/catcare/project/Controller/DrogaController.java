package com.catcare.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.catcare.project.Entity.Droga;
import com.catcare.project.Service.DrogaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/catcare/drogas")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class DrogaController {

    @Autowired
    DrogaService drogaService;

    // Envía la lista de drogas desde drogaService a Thymeleaf para que
    // el HTML pueda acceder a ella.
    // http://localhost:8090/catcare/drogas/all
    @GetMapping("/all")
    @Operation(summary = "Devuelve todas las drogas")
    public List<Droga> mostrarDrogas() {
        return (List<Droga>) drogaService.SearchAll();
    }

    // http://localhost:8090/catcare/drogas/find?id=1
    @GetMapping("/find")
    @Operation(summary = "Devuelve una droga")
    public Droga mostrarInfoDrogas(@RequestParam("id") Long id) {

        // Busca una droga por su ID utilizando el servicio drogaService
        Droga droga = drogaService.SearchById(id);

        if (droga != null) {
            // Verifica si se encontró la droga
        } else {
            // Si no se encontró el dr, retornar vacio
            droga = new Droga();
        }

        return droga;
    }

    // El metodo para agregar solo envia a la pagina, se deja unicamente el post.
    // http://localhost:8090/catcare/drogas/agregar
    @PostMapping("/agregar")
    @Operation(summary = "Agrega una droga")
    public void agregarDroga(@RequestBody Droga droga) {
        // Llama al servicio drogaService para agregar la droga a la base de datos
        drogaService.add(droga);
    }

    // http://localhost:8090/catcare/drogas/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina una droga")
    public void eliminarDroga(@PathVariable("id") Long id) {
        // Llama al servicio drogaService para eliminar la droga con el ID especificado
        drogaService.deleteById(id);
    }

    // El metodo para actualizar solo envia a la pagina, se deja unicamente el post.
    // Post para Update de la droga. Se accede con el ID de la droga.
    // http://localhost:8090/catcare/drogas/update/1
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualiza una droga")
    public void actualizarDroga(@PathVariable("id") Long id, @RequestBody Droga droga) {
        // Llama al servicio drogaService para actualizar los datos de la droga con el ID especificado
        drogaService.update(droga);
    }

}
