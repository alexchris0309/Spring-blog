package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/home")
//    @ResponseBody
    public String welcome (Model vModel){
        String userSession="Alex";
        String role="";
        if(userSession.equals("fer")){
            role="admin";

        }
        vModel.addAttribute("role",role);
        return "home";
    }
}
