package com.grcy.shopmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/index") // adres z przeglądarki który jest wpisany
    public String index() {
        return "index"; //odwołanie do index.html czyli do stronki
    }

}
