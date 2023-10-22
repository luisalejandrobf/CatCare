package com.catcare.project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Veterinario>> mostrarVeterinarios() {
        List<Veterinario> lista = new ArrayList<>(veterinarioService.SearchAll());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // http://localhost:8090/catcare/veterinarios/find?id=1
    @GetMapping("/find")
    @Operation(summary = "Devuelve un veterinario")
    public ResponseEntity<Veterinario> mostrarInfoVeterinarios(@RequestParam("id") Long id) {
        Veterinario veterinario = veterinarioService.SearchById(id);
        if (veterinario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(veterinario, HttpStatus.OK);
    }

    // El metodo para agregar solo envia a la pagina, se deja unicamente el post.
    // http://localhost:8090/catcare/veterinarios/agregar
    @PostMapping("/agregar")
    @Operation(summary = "Agrega un veterinario")
    public ResponseEntity<Veterinario> agregarVeterinario(@RequestBody Veterinario veterinario) {
        try {
            veterinarioService.add(veterinario);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(veterinario, HttpStatus.CREATED);
    }
    
    
    // http://localhost:8090/catcare/veterinarios/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina un veterinario (Cambia su estado a inactivo)")
    public ResponseEntity<String> eliminarVeterinario(@PathVariable("id") Long id) {
        Veterinario veterinario = veterinarioService.SearchById(id);
        if (veterinario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        veterinario.setEstado("Inactivo");
        veterinarioService.update(veterinario);
        return new ResponseEntity<>("Veterinario inactivado", HttpStatus.OK);
    }

    // El metodo para actualizar solo envia a la pagina, se deja unicamente el post.
    // Post para Update del veterinario. Se accede con el ID del Veterinario.
    // http://localhost:8090/catcare/veterinarios/update/1
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualiza un veterinario")
    public ResponseEntity<Veterinario> actualizarVeterinario(@PathVariable("id") Long id, @RequestBody Veterinario veterinario) {
        Veterinario existingVeterinario = veterinarioService.SearchById(id);
        if (existingVeterinario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        veterinario.setId(existingVeterinario.getId());
        veterinarioService.update(veterinario);
        return new ResponseEntity<>(veterinario, HttpStatus.OK);  
    }

    // http://localhost:8090/catcare/veterinarios/tratamientos/1
    @GetMapping("/tratamientos/{id}")
    @Operation(summary = "Devuelve todos los tratamientos aplicados por un veterinario")
    public ResponseEntity<List<Tratamiento>> mostrarTratamientosDeUnPaciente(@PathVariable("id") Long id) {
        Veterinario veterinario = veterinarioService.SearchById(id);
        if (veterinario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Tratamiento> tratamientos = veterinario.getTratamientos();
        return new ResponseEntity<>(tratamientos, HttpStatus.OK);
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
