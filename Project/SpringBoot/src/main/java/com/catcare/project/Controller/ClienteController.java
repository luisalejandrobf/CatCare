package com.catcare.project.Controller;

import com.catcare.project.Controller.Error.ClienteNotFoundException;
import com.catcare.project.Controller.Error.PacienteNotFoundException;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
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
@RequestMapping("/catcare/clientes")
@CrossOrigin(origins = "http://localhost:4200") // Permitir realizar peticiones desde angular
public class ClienteController {

    @Autowired
    ClienteService clienteService;


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
    public void agregarCliente(@RequestBody Cliente cliente) {
        // Llama al servicio clienteService para agregar el cliente a la base de datos
        clienteService.add(cliente);
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

}
