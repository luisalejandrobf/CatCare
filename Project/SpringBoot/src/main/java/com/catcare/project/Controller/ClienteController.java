package com.catcare.project.Controller;

import com.catcare.project.Controller.Error.ClienteNotFoundException;
import com.catcare.project.Controller.Error.PacienteNotFoundException;
import com.catcare.project.DTOs.ClienteDTO;
import com.catcare.project.DTOs.ClienteMapper;
import com.catcare.project.DTOs.VeterinarioDTO;
import com.catcare.project.DTOs.VeterinarioMapper;
import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.UserEntity;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Repository.UserRepository;
import com.catcare.project.Service.ClienteService;
import com.catcare.project.Service.PacienteService;
import com.catcare.project.security.CustomUserDetailService;
import com.catcare.project.security.JWTGenerator;

import io.swagger.v3.oas.annotations.Operation;

import java.util.ArrayList;
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

@RestController // Rest controller
@RequestMapping("/catcare/clientes")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;



    //  Envía la lista de clientes desde ClienteService a Thymeleaf para que el HTML pueda acceder a ella.
    //  http://localhost:8090/catcare/clientes/all
    @GetMapping("/all")
    @Operation(summary = "Devuelve todos los clientes")
    public List<Cliente> mostrarClientes() {
        return (List<Cliente>) clienteService.SearchAll();
    }


    // http://localhost:8090/catcare/clientes/mascotas/1
    @GetMapping("/mascotas/{clienteId}")
    @Operation(summary = "Devuelve todos los pacientes de un cliente")
    public List<Paciente> mostrarPacientesDeCliente(@PathVariable Long clienteId) {
        // Busca un cliente por su ID utilizando el servicio clienteService
        Cliente cliente = clienteService.SearchById(clienteId);

        // Verifica si se encontró el cliente
        if (cliente != null) {
            // Si el cliente existe, obtiene la lista de pacientes (mascotas) asociados a ese cliente
            List<Paciente> mascotas = cliente.getPacientes();

            return mascotas;
        } else {

            // Si no se encontró el cliente, redirige a una página de error
            List<Paciente> mascotas = new ArrayList<>();
            return mascotas;
        }
    }

    //http://localhost:8090/catcare/clientes/details
    @GetMapping("/details")
    public ResponseEntity<Cliente> buscarCliente(){

        Cliente cliente = clienteService.getByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        );

        if(cliente == null){
            return new ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    // http://localhost:8090/catcare/clientes/find?id=1
    @GetMapping("/find")
    @Operation(summary = "Devuelve un cliente")
    public Cliente mostrarInfoClientes(@RequestParam("id") Long id) {
        // Busca un cliente por su ID utilizando el servicio clienteService
        Cliente cliente = clienteService.SearchById(id);

        // Verifica si se encontró el cliente
        if (cliente != null) {

        } else {
            // Si no se encontró el cliente, retornar vacio
            cliente = new Cliente();
        }

        return cliente;
    }

    // El metodo para agregar solo envia a la pagina, se deja unicamente el post.
    // Post para agregar Cliente
    // http://localhost:8090/catcare/clientes/agregar
    @PostMapping("/agregar")
    @Operation(summary = "Agrega un cliente")
    public ResponseEntity agregarCliente(@RequestBody Cliente cliente) {
        // Check if the username already exists in the repository
        if (userRepository.existsByUsername(cliente.getCedula())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        

        UserEntity userEntity = customUserDetailService.ClienteToUser(cliente);
        cliente.setUser(userEntity);

        if(cliente.getUser() != null){
            Cliente newCliente = clienteService.add(cliente);

            if(newCliente == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    


    // http://localhost:8090/catcare/clientes/delete/1
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Elimina un cliente")
    public void eliminarCliente(@PathVariable("id") Long id) {
        // Llama al servicio clienteService para eliminar el cliente con el ID especificado
        clienteService.deleteById(id);
    }


    // El metodo para actualizar solo envia a la pagina, se deja unicamente el post.
    // Post para Update del cliente. Se accede con el ID del Cliente.
    // http://localhost:8090/catcare/clientes/update/1
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualiza un cliente")
    public void actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        // Llama al servicio clienteService para actualizar los datos del cliente con el ID especificado
        clienteService.update(cliente);
    }

    @PostMapping("/login")
    public ResponseEntity verificarIniciarSesion(@RequestBody Cliente cliente){
        
       /*  Cliente cliente = clienteService.SearchByCedula(cedula);

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(cliente.getCedula(), "123"));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(token, HttpStatus.OK); */

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(cliente.getCedula(), "123"));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    // Envia una lista filtrada, haciendo uso del DTO    
    @GetMapping("/allFiltered")
    @Operation(summary = "Devuelve todos los clientes (Unicamente id, cedula y nombre)")
    public ResponseEntity<List<ClienteDTO>> mostrarClientes_filtered() {

        List<Cliente> listaClientes = new ArrayList<>(clienteService.SearchAll());
        List<ClienteDTO> listaClienteDTOs = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            ClienteDTO clienteDTO = ClienteMapper.INSTANCE.convert(cliente);
            listaClienteDTOs.add(clienteDTO);
        }

        return new ResponseEntity<>(listaClienteDTOs, HttpStatus.OK);

    }

}
