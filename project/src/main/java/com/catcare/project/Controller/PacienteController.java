package com.catcare.project.Controller;

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
        }

        return "showPaciente";
    }


    // http://localhost:8090/catcare/pacientes/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Paciente paciente = new Paciente(0, "", "", 0, 0, "", "");
        model.addAttribute("paciente", paciente);
        return "crearPaciente";
    }

    @PostMapping("/agregar")
    public String agregarEstudiante(@ModelAttribute("estudiante") Paciente paciente) {
        pacienteService.add(paciente);
        return "redirect:/pacientes/all";
    }

    //delete
    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable("id") int id) {
        pacienteService.deleteById(id);
        return "redirect:/pacientes/all";
    }

    //update
    @GetMapping("/update/{id}")
    public String actualizarEstudiante(@PathVariable("id") int id, Model model) {
        Paciente paciente = pacienteService.SearchById(id);
        model.addAttribute("paciente", paciente);
        return "actualizarPaciente";
    }

    @PostMapping("/update/{id}")
    public String actualizarEstudiante(@PathVariable("id") int id, @ModelAttribute("estudiante") Paciente paciente) {
        pacienteService.update(paciente);
        return "redirect:/pacientes/all";
    }


}
