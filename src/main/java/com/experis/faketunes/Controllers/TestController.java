package com.experis.faketunes.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController
{
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}

