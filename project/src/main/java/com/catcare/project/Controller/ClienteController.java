package com.catcare.project.Controller;

import com.catcare.project.Controller.Error.ClienteNotFoundException;
import com.catcare.project.Controller.Error.PacienteNotFoundException;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Service.ClienteService;
import com.catcare.project.Service.PacienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/catcare/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    //  Envía la lista de clientes desde ClienteService a Thymeleaf para que el HTML pueda acceder a ella.
    //  http://localhost:8090/catcare/clientes/all
    @GetMapping("/all")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", clienteService.SearchAll());

        // Devuelve la vista llamada "/General/showClientes".
        return "/General/showClientes";
    }


    // http://localhost:8090/catcare/clientes/mascotas/1
    @GetMapping("/mascotas/{clienteId}")
    public String mostrarPacientesDeCliente(@PathVariable Long clienteId, Model model) {
        // Busca un cliente por su ID utilizando el servicio clienteService
        Cliente cliente = clienteService.SearchById(clienteId);

        // Verifica si se encontró el cliente
        if (cliente != null) {
            // Si el cliente existe, obtiene la lista de pacientes (mascotas) asociados a ese cliente
            List<Paciente> mascotas = cliente.getPacientes();

            // Agrega el cliente y la lista de pacientes al modelo para que se puedan mostrar en la vista
            model.addAttribute("cliente", cliente);
            model.addAttribute("pacientes", mascotas);

            // Devuelve la vista llamada "/Cliente/showPacientesDeUnCliente" para mostrar la lista de pacientes del cliente
            return "/Cliente/showPacientesDeUnCliente";
        } else {

            // Si no se encontró el cliente, redirige a una página de error (a implementar en el futuro)
            return "/Error/errorPage";
        }
    }


    // http://localhost:8090/catcare/clientes/find?id=1
    @GetMapping("/find")
    public String mostrarInfoClientes(Model model, @RequestParam("id") Long id) {
        // Busca un cliente por su ID utilizando el servicio clienteService
        Cliente cliente = clienteService.SearchById(id);

        // Verifica si se encontró el cliente
        if (cliente != null) {
            // Si el cliente existe, agrega el cliente al modelo para que se pueda mostrar en la vista
            model.addAttribute("cliente", cliente);
        } else {
            // Si no se encontró el cliente, lanza una excepción de tipo ClienteNotFoundException
            throw new ClienteNotFoundException(id);
        }

        // Devuelve la vista llamada "/General/showCliente" para mostrar la información del cliente
        return "/General/showCliente";
    }


    // http://localhost:8090/catcare/clientes/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        // Crea un nuevo objeto Cliente con valores predeterminados (cadenas vacías)
        Cliente cliente = new Cliente("", "", "", "", "");

        // Se Puede asignar un ID calculado aquí (comentado), si se desea
        // cliente.setId(clienteService.size()+1);

        // Se recomienda añadir un campo oculto para el ID del cliente en el formulario
        // Recordar añadir <input th:field="${cliente.id}" type="hidden"> para evitar tener un ID nulo.


        // Agrega el cliente al modelo para que el formulario pueda acceder a sus datos
        model.addAttribute("cliente", cliente);

        // Devuelve la vista llamada "/General/crearCliente" para mostrar el formulario de creación de cliente
        return "/General/crearCliente";
    }


    // Post para agregar Cliente
    @PostMapping("/agregar")
    public String agregarCliente(@ModelAttribute("cliente") Cliente cliente) {
        // Llama al servicio clienteService para agregar el cliente a la base de datos
        clienteService.add(cliente);

        // Redirige al usuario a la página que muestra la lista de todos los clientes
        return "redirect:/catcare/clientes/all";
    }


    // http://localhost:8090/catcare/clientes/delete/1
    @GetMapping("/delete/{id}")
    public String eliminarCliente(@PathVariable("id") Long id) {
        // Llama al servicio clienteService para eliminar el cliente con el ID especificado
        clienteService.deleteById(id);

        // Redirige al usuario de regreso a la página que muestra la lista de todos los clientes
        return "redirect:/catcare/clientes/all";
    }


    // http://localhost:8090/catcare/clientes/update/1
    @GetMapping("/update/{id}")
    public String actualizarCliente(@PathVariable("id") Long id, Model model) {
        // Busca un cliente por su ID utilizando el servicio clienteService
        Cliente cliente = clienteService.SearchById(id);

        // Agrega el cliente al modelo para que se pueda mostrar en el formulario de actualización
        model.addAttribute("cliente", cliente);

        // Devuelve la vista llamada "/General/actualizarCliente" para mostrar el formulario de actualización
        return "/General/actualizarCliente";
    }


    // Post para Update del cliente. Se accede con el ID del Cliente.
    @PostMapping("/update/{id}")
    public String actualizarCliente(@PathVariable("id") Long id, @ModelAttribute("cliente") Cliente cliente) {
        // Llama al servicio clienteService para actualizar los datos del cliente con el ID especificado
        clienteService.update(cliente);

        // Redirige al usuario de regreso a la página que muestra la lista de todos los clientes
        return "redirect:/catcare/clientes/all";
    }

}
