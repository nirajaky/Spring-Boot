package com.nirajaky.demoBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String firstHandler(){
        return "This is our First Page, Request sent through Request Mapping";
    }

    @RequestMapping("/")
    @ResponseBody
    public String secondHandler(){
        return "This is our Second Page, Request sent through Request Mapping";
    }
}
