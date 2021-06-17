package com.springsecurity.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getPage(){

        return "index";
    }

    @GetMapping("/login")
    public String myLoginPage(){

        return "login";
    }

    @GetMapping("/admin")
    public String admin(){

        return "admin";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){

        return "accessDenied";
    }
}
