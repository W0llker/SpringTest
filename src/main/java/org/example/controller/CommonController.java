package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class CommonController {
    @RequestMapping("/home")
    public String getMainPage() {
        return "main-page";
    }
}
