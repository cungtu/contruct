package com.example.construct.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @RequestMapping(value={"", "/"})
    public String homePage()
    {
        return "index";
    }
}
