package br.ufjf.dcc193.trabalho2.controller;

import br.ufjf.dcc193.trabalho2.model.Trabalho;
import br.ufjf.dcc193.trabalho2.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class TrabalhoController {

    @Autowired
    private TrabalhoRepository rep;

    @GetMapping("trabalhos.html")
    public ModelAndView trabalhos(){
        ModelAndView mv = new ModelAndView();
        List<Trabalho> trabalhos = rep.findAll();
        mv.addObject("trabalhos",trabalhos);
        return mv;
    }

    @GetMapping("trabalhos-editar/{id}.html")
    public ModelAndView editarTrabalho(@PathVariable Long id){
        ModelAndView mv = new ModelAndView();
        Optional<Trabalho> trabalho = rep.findById(id);
        mv.addObject("trabalho",trabalho);
        return mv;
    }
}
