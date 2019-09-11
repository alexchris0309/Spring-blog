package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    private long count =0;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, Model vModel) {
        vModel.addAttribute("name", name);
        return "hello";
    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name) {
//        return "<h1>Hello " + name + "!</h1>";
//    }
//
//
//    @PostMapping("/hello")
//        @ResponseBody
//        public String goodbye(){
//            return "Goodbye From Spring";
//        }


    }

