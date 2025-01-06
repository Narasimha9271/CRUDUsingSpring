package com.nani.webApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HomeController {

    @RequestMapping("/")
//    @ResponseBody
    public String greet(){
            return "Welcome Nani";
    }

    @RequestMapping("/about")
    @ResponseBody
    public String about(){
        return "About Page of our web app";
    }

}
