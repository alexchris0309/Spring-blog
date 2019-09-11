package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RollController {


    @GetMapping("/roll-dice")
    public String Guess() {
        return "guess";
    }


    @RequestMapping(path = "/roll-dice/{n}", method = RequestMethod.GET)
    public String Show(@PathVariable int n, Model vModel) {
        int random = (int) Math.floor(Math.random() * 6);
        Boolean isTrue = (n == random);
        vModel.addAttribute("isTrue", isTrue);
        vModel.addAttribute("roll", random);
        return "answer";
    }
}


