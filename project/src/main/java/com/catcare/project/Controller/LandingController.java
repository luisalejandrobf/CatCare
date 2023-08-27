package com.catcare.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.catcare.project.Entity.Cliente;
import com.catcare.project.Service.ClienteService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/catcare")
public class LandingController {
    
    @Autowired
    ClienteService clienteService;
    
    // http://localhost:8090/catcare/landing
    @RequestMapping("/landing")
    public String showLandingPage(Model model){
        return "index.html";
    }

    // http://localhost:8090/catcare/signin/3434
    @GetMapping("/signin/{cedula}")
    public String mostrarClientes(@PathVariable("cedula") String cedula,Model model) {
        
        String resp = "login";
        Cliente cliente = clienteService.SearchByCedula(cedula);
        if (cliente != null) {
            // System.out.println("SIGNIN IF NOMBRE "+cliente.getNombre());
            resp = "redirect:/catcare/pacientes/all";
            // System.out.println("SIGNIN IF : "+cedula);
        } else {
             // System.out.println("SIGNIN ELSE :"+cedula);
             resp  = "pagina_error_login";
        }        
        return resp;
    }

}
