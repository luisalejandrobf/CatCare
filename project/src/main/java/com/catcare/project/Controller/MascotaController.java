package com.catcare.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.catcare.project.Entity.Mascota;
import com.catcare.project.Service.MascotaService;

@Controller
@RequestMapping("/catcare/mascotas")
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    // http://localhost:8090/catcare/mascotas/all
    @GetMapping("/all")
    public String mostrarEstudiantes(Model model) {

        // Sends mascotas from MascotaService to thymeleaf for the HTML to fetch
        model.addAttribute("mascotas", mascotaService.SearchAll());

        return "showMascotasList";
    }

    // http://localhost:8090/catcare/mascotas/find?id=1
    @GetMapping("/find")
    public String mostrarInfoEstudiante(Model model, @RequestParam("id") int id) {

        Mascota mascota = mascotaService.SearchById(id);
        if (mascota != null) {
            model.addAttribute("mascota", mascota);
        }

        return "showMascota";
    }

}
