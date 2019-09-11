package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class MathController {

//    /subtract/3/from/10	7
//            /multiply/4/and/5	20
//            /divide/6/by/3	2


    @RequestMapping(path = "/add/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number, @PathVariable int number2) {
        return number +" + "+ number2 +" = " + (number + number2) + "!";
    }

    @RequestMapping(path = "/subtract/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int number, @PathVariable int number2) {
        return number +" - "+ number2 +" = " + (number - number2) + "!";
    }

    @RequestMapping(path = "/multiply/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int number, @PathVariable int number2) {
        return number +" * "+ number2 +" = " + (number * number2) + "!";
    }
    @RequestMapping(path = "/divide/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int number, @PathVariable int number2) {
        return number +" / "+ number2 +" = " + (number / number2) + "!";
    }




}


