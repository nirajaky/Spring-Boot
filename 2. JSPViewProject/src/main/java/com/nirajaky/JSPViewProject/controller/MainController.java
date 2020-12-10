package com.nirajaky.JSPViewProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/")
    public String getHome(){
        System.out.println("This is Home.jsp");
        return "home.jsp";
    }
}
