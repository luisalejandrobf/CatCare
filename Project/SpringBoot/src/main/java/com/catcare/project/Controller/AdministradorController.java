package com.catcare.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.catcare.project.DTOs.AdministradorDTO;
import com.catcare.project.DTOs.AdministradorMapper;
import com.catcare.project.DTOs.VeterinarioDTO;
import com.catcare.project.DTOs.VeterinarioMapper;
import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.UserEntity;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Repository.UserRepository;
import com.catcare.project.Service.AdministradorService;
import com.catcare.project.security.CustomUserDetailService;
import com.catcare.project.security.JWTGenerator;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/catcare/administradores")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;


    //@Autowired
   /// JWTGenerator jwtGenerator;

    // Envía la lista de administradores desde administradorService a Thymeleaf para que
    // el HTML pueda acceder a ella.
    // http://localhost:8090/catcare/administradores/all
    @GetMapping("/all")
    @Operation(summary = "Devuelve todos los administradores")
    public List<Administrador> mostrarAdministradores() {
        return (List<Administrador>) administradorService.SearchAll();
    }


    // http://localhost:8090/catcare/administradores/details
    @GetMapping("/details")
    public ResponseEntity<AdministradorDTO> buscarAdministrador(){

        Administrador administrador = administradorService.findByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );

        AdministradorDTO administradorDTO = AdministradorMapper.INSTANCE.convert(administrador);


        if(administrador == null){
            return new ResponseEntity<AdministradorDTO>(administradorDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AdministradorDTO>(administradorDTO, HttpStatus.OK);
    }


    // http://localhost:8090/catcare/administradores/find?id=1
    @GetMapping("/find")
    @Operation(summary = "Devuelve un administrador")
    public Administrador mostrarInfoAdministradores(@RequestParam("id") Long id) {

        // Busca un administrador por su ID utilizando el servicio administradorService
        Administrador administrador = administradorService.SearchById(id);

        if (administrador != null) {
            // Verifica si se encontró el administrador
        } else {
            // Si no se encontró el administrador, retornar vacio
            administrador = new Administrador();
        }

        return administrador;
    }

    // El metodo para agregar solo envia a la pagina, se deja unicamente el post.
    // http://localhost:8090/catcare/administradores/agregar
    @PostMapping("/agregar")
    @Operation(summary = "Agrega un administrador")
    public ResponseEntity<Administrador> agregarAdministrador(@RequestBody Administrador administrador) {
        // Llama al servicio administradorService para agregar el administrador a la base de
        // datos
        //administradorService.add(administrador);

        if(userRepository.existsByUsername(administrador.getUsuario())) {
            return new ResponseEntity<Administrador>(administrador, HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = customUserDetailService.AdministradorToUser(administrador);
        administrador.setUser(userEntity);
        Administrador newAdministrador = administradorService.add(administrador);
        if(newAdministrador == null){
            return new ResponseEntity<Administrador>(newAdministrador, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Administrador>(newAdministrador, HttpStatus.CREATED);
    }

    // http://localhost:8090/catcare/administradores/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina un administrador")
    public void eliminarAdministrador(@PathVariable("id") Long id) {
        // Llama al servicio administradorService para eliminar el administrador con el ID especificado
        administradorService.deleteById(id);
    }

    // El metodo para actualizar solo envia a la pagina, se deja unicamente el post.
    // Post para Update del administrador. Se accede con el ID del administrador.
    // http://localhost:8090/catcare/administradores/update/1
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualiza un administrador")
    public void actualizarAdministrador(@PathVariable("id") Long id, @RequestBody Administrador administrador) {
        // Llama al servicio administradorService para actualizar los datos del
        // administrador con el ID especificado
        administradorService.update(administrador);
    }

    // Verificar inicio de sesión para un administrador, dada cédula y contraseña
    @PostMapping("/login")
    @Operation(summary = "Verifica el inicio de sesión de un administrador")
    public ResponseEntity verificarInicioSesion(@RequestBody Administrador administrador) {   
        // Llama al servicio administradorService para verificar el inicio de sesión
        // Busca un administrador por la cédula
       /*Administrador administrador = administradorService.findByCedula(cedula);
        AdministradorDTO administradorDTO = AdministradorMapper.INSTANCE.convert(administrador);

        if (administrador != null) {
            // Verifica si la contraseña coincide
            if (administrador.getContrasena().equals(contrasena)) {
                return new ResponseEntity<AdministradorDTO>(administradorDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<AdministradorDTO>(administradorDTO, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<AdministradorDTO>(administradorDTO, HttpStatus.NOT_FOUND);
        } */ 

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(administrador.getCedula(), administrador.getContrasena()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);

    }


}
