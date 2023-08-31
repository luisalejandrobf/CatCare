package com.catcare.project.Controller;

import com.catcare.project.Controller.Error.PacienteNotFoundException;
import com.catcare.project.Entity.Paciente;
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

        return "showPacientes";
    }

    // http://localhost:8090/catcare/pacientes/find?id=1
    @GetMapping("/find")
    public String mostrarInfoPacientes(Model model, @RequestParam("id") int id) {

        Paciente paciente = pacienteService.SearchById(id);
        if (paciente != null) {
            model.addAttribute("paciente", paciente);
        } else {
            // Throw error
            throw new PacienteNotFoundException(id);
        }

        return "showPaciente";
    }


    // http://localhost:8090/catcare/pacientes/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Paciente paciente = new Paciente(0, "", "", 0, 0, "", "", "");

        // Se puede asignar un ID calculado
        // paciente.setId(pacienteService.size()+1);

        // Recordar añadir <input th:field="${paciente.id}" type="hidden"> para evitar tener un ID nulo.

        model.addAttribute("paciente", paciente);
        return "crearPaciente";
    }

    // Post para agregar Paciente
    @PostMapping("/agregar")
    public String agregarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        
        pacienteService.add(paciente);
        return "redirect:/catcare/pacientes/all";
    }

    // http://localhost:8090/catcare/pacientes/delete/1
    @GetMapping("/delete/{id}")
    public String eliminarPaciente(@PathVariable("id") int id) {
        pacienteService.deleteById(id);
        return "redirect:/catcare/pacientes/all";
    }

    // http://localhost:8090/catcare/pacientes/update/1
    @GetMapping("/update/{id}")
    public String actualizarPaciente(@PathVariable("id") int id, Model model) {
        Paciente paciente = pacienteService.SearchById(id);
        model.addAttribute("paciente", paciente);
        return "actualizarPaciente";
    }

    // Post para Update del cliente. Se accede con el ID del Paciente.
    @PostMapping("/update/{id}")
    public String actualizarPaciente(@PathVariable("id") int id, @ModelAttribute("paciente") Paciente paciente) {
        pacienteService.update(paciente);
        return "redirect:/catcare/pacientes/all";
    }

}
