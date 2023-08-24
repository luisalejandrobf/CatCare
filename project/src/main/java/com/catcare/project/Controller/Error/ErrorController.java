package com.catcare.project.Controller.Error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    
    @ExceptionHandler(PacienteNotFoundException.class)
    public String error(Model model, PacienteNotFoundException exception){
        model.addAttribute("id", exception.getId());
        return "/Error/pagina_error_pacienteNoEncontrado";
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public String error(Model model, ClienteNotFoundException exception){
        model.addAttribute("id", exception.getId());
        return "/Error/pagina_error_clienteNoEncontrado";
    }

}
