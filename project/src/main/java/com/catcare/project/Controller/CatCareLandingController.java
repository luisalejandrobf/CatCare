package com.catcare.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/catcare")
public class CatCareLandingController {
    
    // http://localhost:8090/catcare/landing
    @RequestMapping("/landing")
    public String showLandingPage(Model model){
        return "index.html";
    }

}
