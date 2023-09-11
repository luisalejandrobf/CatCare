package com.catcare.project.Controller;

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
@RequestMapping("/catcare/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    // http://localhost:8090/catcare/pacientes/all
    @GetMapping("/all")
    public String mostrarPacientes(Model model) {

        // Sends mascotas from PacienteService to thymeleaf for the HTML to fetch
        model.addAttribute("pacientes", pacienteService.SearchAll());

        return "/General/showPacientes";
    }

    // http://localhost:8090/catcare/pacientes/find?id=1
    @GetMapping("/find")
    public String mostrarInfoPacientes(Model model, @RequestParam("id") Long id) {

        Paciente paciente = pacienteService.SearchById(id);
        if (paciente != null) {
            model.addAttribute("paciente", paciente);
        } else {
            // Throw error
            throw new PacienteNotFoundException(id);
        }

        return "/General/showPaciente";
    }


    // http://localhost:8090/catcare/pacientes/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Paciente paciente = new Paciente("", "", 0, 0, "", "", "");

        // Se puede asignar un ID calculado
        // paciente.setId(pacienteService.size()+1);

        // Recordar añadir <input th:field="${paciente.id}" type="hidden"> para evitar tener un ID nulo.

        model.addAttribute("paciente", paciente);
        return "/General/crearPaciente";
    }

    // Post para agregar Paciente
    @PostMapping("/agregar")
    public String agregarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        
        pacienteService.add(paciente);
        return "redirect:/catcare/pacientes/all";
    }

    // Delete GENERAL
    // http://localhost:8090/catcare/pacientes/delete/1
    @GetMapping("/delete/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id) {
        pacienteService.deleteById(id);
        return "redirect:/catcare/pacientes/all";
    }

    // UPDATE GENERAL

    // http://localhost:8090/catcare/pacientes/update/1
    @GetMapping("/update/{id}")
    public String actualizarPaciente(@PathVariable("id") Long id, Model model) {
        Paciente paciente = pacienteService.SearchById(id);
        model.addAttribute("paciente", paciente);
        return "/General/actualizarPaciente";
    }

    // Post para Update del cliente. Se accede con el ID del Paciente.
    @PostMapping("/update/{id}")
    public String actualizarPaciente(@PathVariable("id") Long id, @ModelAttribute("paciente") Paciente paciente) {
            
        pacienteService.update(paciente);
    
        return "redirect:/catcare/pacientes/all";
    }





    

    // ESTANDO EN UN PACIENTE (Regresa a la URL de visualizacion de las mascotas del cliente)
    
    // UPDATE
    // http://localhost:8090/catcare/pacientes/update/1
    @GetMapping("/update/{clienteid}/{id}")
    public String actualizarPacienteDeUnCliente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid, Model model) {
        Paciente paciente = pacienteService.SearchById(id);
        model.addAttribute("paciente", paciente);
        model.addAttribute("clienteid", clienteid);

        return "/Cliente/actualizarPacienteDeUnCliente";
    }

    // Post para Update del cliente. Se accede con el ID del Paciente.
    @PostMapping("/update/{clienteid}/{id}")
    public String actualizarPacienteDeUnCliente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid, @ModelAttribute("paciente") Paciente paciente) {
            
        pacienteService.update(paciente);
    
        return "redirect:/catcare/clientes/mascotas/{clienteid}";
    }

    // metodo para encontrar mascota de cliente
    @GetMapping("/mostrar/{clienteid}/{id}")
    public String mostrarInfoPacienteDeUnCliente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid, Model model) {
        Paciente paciente = pacienteService.SearchById(id);
        model.addAttribute("paciente", paciente);
        model.addAttribute("clienteid", clienteid);

        return "/Cliente/showPacienteDeUnCliente";
    }

    // DELETE
    // http://localhost:8090/catcare/pacientes/delete/1
    @GetMapping("/delete/{clienteid}/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id, @PathVariable("clienteid") Long clienteid) {
        pacienteService.deleteById(id);
        return "redirect:/catcare/clientes/mascotas/{clienteid}";
    }


}
