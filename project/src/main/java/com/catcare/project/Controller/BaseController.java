package com.catcare.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("")
public class BaseController {

    // Esta es la acción que redirige desde la raíz (http://localhost:8090/) a la página de aterrizaje
    // (http://localhost:8090/catcare/landing)
    @RequestMapping("")
    public RedirectView redirectToLanding() {
        return new RedirectView("/catcare/landing");
    }

}
