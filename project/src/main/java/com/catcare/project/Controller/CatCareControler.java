package com.catcare.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catcare")
public class CatCareControler {
    
    @RequestMapping("/landing")
    public String showLandingPage(Model model){
        return "index.html";
    }

}
