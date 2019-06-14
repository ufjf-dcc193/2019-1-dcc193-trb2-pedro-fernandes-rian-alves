package br.ufjf.dcc193.trabalho2.controller;

import br.ufjf.dcc193.trabalho2.model.Avaliador;
import br.ufjf.dcc193.trabalho2.repository.AvaliadorRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AvaliadorController {
    @Autowired
    private AvaliadorRepository rep;

    @GetMapping("avaliadores.html")
    public ModelAndView avaliadores(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("avaliadores",rep.findAll());
        return mv;
    }

    @GetMapping("avaliadores-editar/{id}.html")
    public ModelAndView areaEditar(@PathVariable Long id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("avaliador", rep.getOne(id));
        mv.setViewName("avaliadores-editar");
        return mv;
    }

    @RequestMapping(value = "/novo.html", method = RequestMethod.GET)
    public ModelAndView avaliadorCadastrar()
    {
        Avaliador avaliador = new Avaliador();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliadores-cadastrar");
        mv.addObject("avaliador", avaliador);
        return mv;
    }

    @PostMapping(value = "/criar.html")
    public ModelAndView avaliadorSalvar(@Valid Avaliador avaliador, BindingResult binding){
    
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("avaliadores-cadastrar");
            mv.addObject("avaliador", avaliador);
            return mv;
        }
        rep.save(avaliador);
        mv.setViewName("redirect:loin.html");
       return mv;
       
    }


}
