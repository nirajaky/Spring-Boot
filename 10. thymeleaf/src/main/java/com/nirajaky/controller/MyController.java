package com.nirajaky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller     // @RestController = @GetMapping + @ResponseBody
public class MyController {

//    @RequestMapping(value = "/about", method = RequestMethod.GET)
    @GetMapping("/about")
    public String about(Model model){
        System.out.println("Inside about Handler");

        model.addAttribute("name", "Niraj Kumar");
        model.addAttribute("date", new Date().toString());
        return "about";
    }

    //Iteration in Thymeleaf
    @GetMapping("/loop")
    public String iteration(Model model){
        List<String> list = List.of("Niraj kumar", "Sonu Kumar", "Ankit Kes", "Bill Gates", "Mark");
        model.addAttribute("names", list);

        return "iterate";
    }

    // Handler for conditional statement
    @GetMapping("/condition")
    public String conditionHandler(Model m){
        m.addAttribute("isActive", false);
        m.addAttribute("gender", "F");

        List<Integer> myList = List.of(11,22,33,55);
        m.addAttribute("myList", myList);
        return "condition";
    }

    // Handler for fragment inclution
    @GetMapping("/service")
    public String service(){

        return "service";
    }
}
