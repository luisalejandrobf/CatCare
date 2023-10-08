package com.catcare.project.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

        // Devuelve la cadena "index.html", que generalmente corresponde a una vista de aterrizaje en el proyecto web
        return "index.html";
    }


    // http://localhost:8090/catcare/signin/3434
    @GetMapping("/signin/{cedula}")
    public String searchByCedula(@PathVariable String cedula) {
        // Busca un cliente por su número de cédula utilizando el servicio clienteService
        Cliente cliente = clienteService.SearchByCedula(cedula);
        String resp;

        // Verifica si se encontró el cliente
        if (cliente != null) {
            // Si el cliente existe, obtiene su ID y redirige al usuario a la página que muestra las mascotas del cliente
            Long clientId = cliente.getId();
            return "redirect:/catcare/clientes/mascotas/" + clientId; // Lleva a ver las mascotas del cliente con su ID.
        } else {
            // Si no se encontró el cliente, asigna una respuesta de error
            resp = "/Error/pagina_error_login";
        }

        // Devuelve la respuesta, que puede ser una página de error o una redirección a la página de inicio de sesión
        return resp;
    }

}
