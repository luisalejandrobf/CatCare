package com.catcare.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Service.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/catcare/veterinarios")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class VeterinarioController {
    
    @Autowired
    VeterinarioService veterinarioService;

    //  Envía la lista de veterinarios desde VeterinarioService a Thymeleaf para que el HTML pueda acceder a ella.
     //  http://localhost:8090/catcare/veterinarios/all
    @GetMapping("/all")
    @Operation(summary = "Devuelve todos los veterinarios")
    public List<Veterinario> mostrarVeterinarios() {
        return (List<Veterinario>) veterinarioService.SearchAll();
    }

    //http://localhost:8090/catcare/veterinarios/find?id=1
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
        // Llama al servicio veterinarioService para agregar el veterinario a la base de datos
        veterinarioService.add(veterinario);
    }

    // http://localhost:8090/catcare/veterinarios/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina un veterinario")
    public void eliminarVeterinario(@PathVariable("id") Long id) {
        // Llama al servicio veterinarioService para eliminar el veterinario con el ID especificado
        veterinarioService.deleteById(id);
    }


    // El metodo para actualizar solo envia a la pagina, se deja unicamente el post.
    // Post para Update del veterinario. Se accede con el ID del Veterinario.
    // http://localhost:8090/catcare/veterinarios/update/1
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualiza un veterinario")
    public void actualizarVeterinario(@PathVariable("id") Long id, @RequestBody Veterinario veterinario) {
        // Llama al servicio veterinarioService para actualizar los datos del veterinario con el ID especificado
        veterinarioService.update(veterinario);
    }




}
