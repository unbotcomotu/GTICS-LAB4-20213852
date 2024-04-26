package com.example.gticslab420213852.Controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    private String vistaInicial(){
        return "vistaPrincipal";
    }

    @GetMapping("/empleados")
    private String empleados(Model model){
        return "empleados";
    }
}
