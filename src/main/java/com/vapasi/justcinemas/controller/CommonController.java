package com.vapasi.justcinemas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {


    @GetMapping("/terms")
    public String getTerms(){
        return "terms";
    }

    @GetMapping("/about_us")
    public String getAbout(){
        return "about_us";
    }

}
