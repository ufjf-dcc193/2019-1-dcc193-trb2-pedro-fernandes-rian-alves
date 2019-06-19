package br.ufjf.dcc193.trabalho2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class InicioController {

    @RequestMapping(value={"inicio.html" })
    public ModelAndView inicio() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("inicio");
        return mv;
    }
    
}