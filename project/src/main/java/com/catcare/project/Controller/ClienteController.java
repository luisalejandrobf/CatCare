package com.catcare.project.Controller;

import com.catcare.project.Controller.Error.ClienteNotFoundException;
import com.catcare.project.Controller.Error.PacienteNotFoundException;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Service.ClienteService;
import com.catcare.project.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/catcare/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    // http://localhost:8090/catcare/clientes/all
    @GetMapping("/all")
    public String mostrarClientes(Model model) {

        // Sends clientes from ClienteService to thymeleaf for the HTML to fetch
        model.addAttribute("clientes", clienteService.SearchAll());

        return "showClientes";
    }

    // http://localhost:8090/catcare/clientes/find?id=1
    @GetMapping("/find")
    public String mostrarInfoClientes(Model model, @RequestParam("id") int id) {

        Cliente cliente = clienteService.SearchById(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
        } else {
            // Throw error
            throw new ClienteNotFoundException(id);
        }

        return "showCliente";
    }


    // http://localhost:8090/catcare/clientes/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Cliente cliente = new Cliente(0, "", "", "", "");

        // Se puede asignar un ID calculado
        // cliente.setId(clienteService.size()+1);

        // Recordar añadir <input th:field="${cliente.id}" type="hidden"> para evitar tener un ID nulo.

        model.addAttribute("cliente", cliente);
        return "crearCliente";
    }

    // Post para agregar Cliente
    @PostMapping("/agregar")
    public String agregarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.add(cliente);
        return "redirect:/catcare/clientes/all";
    }

    // http://localhost:8090/catcare/clientes/delete/1
    @GetMapping("/delete/{id}")
    public String eliminarCliente(@PathVariable("id") int id) {
        clienteService.deleteById(id);
        return "redirect:/catcare/clientes/all";
    }

    // http://localhost:8090/catcare/clientes/update/1
    @GetMapping("/update/{id}")
    public String actualizarCliente(@PathVariable("id") int id, Model model) {
        Cliente cliente = clienteService.SearchById(id);
        model.addAttribute("cliente", cliente);
        return "actualizarCliente";
    }

    // Post para Update del cliente. Se accede con el ID del Cliente.
    @PostMapping("/update/{id}")
    public String actualizarCliente(@PathVariable("id") int id, @ModelAttribute("cliente") Cliente cliente) {
        clienteService.update(cliente);
        return "redirect:/catcare/clientes/all";
    }


}
