package com.catcare.project.Controller.Error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotFoundErrorController implements ErrorController {
    
    @RequestMapping("/error")
    public String handleError(Model model) {
        return "pagina_error_generica";
    }
}
