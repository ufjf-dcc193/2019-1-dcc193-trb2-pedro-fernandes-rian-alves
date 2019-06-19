package br.ufjf.dcc193.trabalho2.controller;

import br.ufjf.dcc193.trabalho2.model.Trabalho;
import br.ufjf.dcc193.trabalho2.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;
import java.util.Optional;

@Controller
public class TrabalhoController {

    @Autowired
    private TrabalhoRepository rep;

    @GetMapping("/trabalhos/listar.html")
    public ModelAndView trabalhos(){
        ModelAndView mv = new ModelAndView();
        List<Trabalho> trabalhos = rep.findAll();
        mv.setViewName("trabalhos-listar");
        mv.addObject("trabalhos",trabalhos);
        return mv;
    }

    @GetMapping("trabalhos/cadastrar.html")
    public ModelAndView trabalhoCadasatrar() {
        Trabalho trabalho = new Trabalho();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("trabalhos-cadastrar");
        mv.addObject("trabalho", trabalho);
        return mv;
    }

    @PostMapping("trabalhos/cadastrar.html")
    public ModelAndView trabalhoCadastrarPost(Trabalho trabalho){
        ModelAndView mv = new ModelAndView();

        rep.save(trabalho);
        mv.addObject("trabalho", trabalho);
        mv.setViewName("redirect:/trabalhos/listar.html");
        return mv;
    }


    @GetMapping("/trabalhos/editar/{id}")
    public ModelAndView trabalhoEditar(@PathVariable Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("trabalhos-editar");
        Optional<Trabalho> trabalho = rep.findById(id);
        mv.addObject("trabalho",trabalho);
        return mv;
    }

    @PostMapping("/trabalhos/editar.html")
    public RedirectView trabalhoEditarPost (Trabalho trabalho){
        rep.save(trabalho);
        return new RedirectView("/trabalhos/listar.html");
    }

    @GetMapping("/trabalhos/deletar/{id}")
    public RedirectView trabalhoDeletar(@PathVariable Long id){
        rep.deleteById(id);
        return new RedirectView("/trabalhos/listar.html");
    }
}
