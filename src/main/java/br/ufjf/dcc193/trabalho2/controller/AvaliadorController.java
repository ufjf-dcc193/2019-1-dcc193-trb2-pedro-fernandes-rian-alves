package br.ufjf.dcc193.trabalho2.controller;

import br.ufjf.dcc193.trabalho2.model.Avaliador;
import br.ufjf.dcc193.trabalho2.repository.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("avaliadores-cadastrar.html")
    public ModelAndView avaliadorCadastrar()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliadores-cadastrar");
        return mv;
    }

    @PostMapping("avaliadores-cadastrar.html")
    public RedirectView avaliadorCadastrar(Avaliador avaliador){
        rep.save(avaliador);
        return new RedirectView("/avaliadores.html?cadastrado=true");
    }


}
