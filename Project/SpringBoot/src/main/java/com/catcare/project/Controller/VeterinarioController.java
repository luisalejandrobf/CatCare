package com.catcare.project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.catcare.project.DTOs.VeterinarioDTO;
import com.catcare.project.DTOs.VeterinarioMapper;
import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Entity.UserEntity;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Repository.UserRepository;
import com.catcare.project.Service.VeterinarioService;
import com.catcare.project.security.CustomUserDetailService;
import com.catcare.project.security.JWTGenerator;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/catcare/veterinarios")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    // Envía la lista de veterinarios desde VeterinarioService a Thymeleaf para que
    // el HTML pueda acceder a ella.
    // http://localhost:8090/catcare/veterinarios/all
    @GetMapping("/all")
    @Operation(summary = "Devuelve todos los veterinarios")
    public ResponseEntity<List<VeterinarioDTO>> mostrarVeterinarios() {
        List<Veterinario> listaVeterinarios = new ArrayList<>(veterinarioService.SearchAll());
        List<VeterinarioDTO> listaVeterinarioDTOs = new ArrayList<>();

        for (Veterinario veterinario : listaVeterinarios) {
            VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);
            listaVeterinarioDTOs.add(veterinarioDTO);
        }

        return new ResponseEntity<>(listaVeterinarioDTOs, HttpStatus.OK);
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
    public ResponseEntity agregarVeterinario(@RequestBody Veterinario veterinario) {
        if (userRepository.existsByUsername(veterinario.getCedula())) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    
        UserEntity userEntity = customUserDetailService.VeterinarioToUser(veterinario);
        veterinario.setUser(userEntity);
    
        if (veterinario.getUser() != null) {
            Veterinario newVeterinario = veterinarioService.add(veterinario);
    
            if (newVeterinario == null) {
                return new ResponseEntity<VeterinarioDTO>(HttpStatus.BAD_REQUEST);
            }
    
            return new ResponseEntity<>(newVeterinario, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<VeterinarioDTO>(HttpStatus.BAD_REQUEST);
        }
    }
    

    
    // http://localhost:8090/catcare/veterinarios/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina un veterinario (Cambia su estado a inactivo)")
    public void eliminarVeterinario(@PathVariable("id") Long id) {
        Veterinario veterinario = veterinarioService.SearchById(id);
        if (veterinario == null) {
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        veterinario.setEstado("Inactivo");
        veterinarioService.update(veterinario);
        // return new ResponseEntity<>("Veterinario inactivado", HttpStatus.OK);
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


    // Verificar inicio de sesión para un veterinario, dada cédula y contraseña
    @PostMapping("/login")
    @Operation(summary = "Verifica el inicio de sesión de un veterinario")
    public ResponseEntity verificarInicioSesion(@RequestBody Veterinario veterinario) {
        // Llama al servicio veterinarioService para verificar el inicio de sesión
        // Busca un veterinario por la cédula
        //Veterinario veterinario = veterinarioService.findByCedula(cedula);
        //VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);

        /*if (veterinario != null) {
            // Verifica si la contraseña coincide
            if (veterinario.getContrasena().equals(contrasena)) {
                return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.NOT_FOUND);
        } */

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(veterinario.getCedula(), veterinario.getContrasena()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);

    }

    // http://localhost:8090/veterinario/details
    @GetMapping("/details")
    public ResponseEntity<VeterinarioDTO> buscarVeterinario(){

        Veterinario veterinario = veterinarioService.findByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );

        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);


        if(veterinario == null){
            return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
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
