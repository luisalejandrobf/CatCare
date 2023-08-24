package com.catcare.project.Controller;

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
        }

        return "showCliente";
    }


    // http://localhost:8090/catcare/clientes/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Cliente cliente = new Cliente(0, "", "", "", "");
        model.addAttribute("cliente", cliente);
        return "crearCliente";
    }

    @PostMapping("/agregar")
    public String agregarEstudiante(@ModelAttribute("estudiante") Cliente cliente) {
        clienteService.add(cliente);
        return "redirect:/clientes/all";
    }

    //delete
    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable("id") int id) {
        clienteService.deleteById(id);
        return "redirect:/clientes/all";
    }

    //update
    @GetMapping("/update/{id}")
    public String actualizarEstudiante(@PathVariable("id") int id, Model model) {
        Cliente cliente = clienteService.SearchById(id);
        model.addAttribute("cliente", cliente);
        return "actualizarCliente";
    }

    @PostMapping("/update/{id}")
    public String actualizarEstudiante(@PathVariable("id") int id, @ModelAttribute("estudiante") Cliente cliente) {
        clienteService.update(cliente);
        return "redirect:/clientes/all";
    }


}
