package br.ufjf.dcc193.trabalho2.controller;

import br.ufjf.dcc193.trabalho2.model.Avaliador;
import br.ufjf.dcc193.trabalho2.model.Revisao;
import br.ufjf.dcc193.trabalho2.model.Trabalho;
import br.ufjf.dcc193.trabalho2.repository.AreaConhecimentoRepository;
import br.ufjf.dcc193.trabalho2.repository.AvaliadorRepository;
import br.ufjf.dcc193.trabalho2.repository.RevisaoRepository;
import br.ufjf.dcc193.trabalho2.repository.TrabalhoRepository;
import br.ufjf.dcc193.trabalho2.service.LoginService;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AvaliadorController {
    @Autowired
    private AvaliadorRepository rep;

    @Autowired
    private AreaConhecimentoRepository reparea;

    @Autowired
    private TrabalhoRepository repTrab;

    @Autowired
    private RevisaoRepository repRev;

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("avaliador", new Avaliador());
        mv.setViewName("login");
        return mv;
    }


    @PostMapping(value = "login.html")
    public ModelAndView login(@Valid Avaliador avaliador, BindingResult binding, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (binding.hasErrors()) {
            mv.setViewName("login");
            mv.addObject("avaliador", avaliador);

        }
        Avaliador a = rep.findOneByEmailAndCodigo(avaliador.getEmail(), avaliador.getCodigo());
        System.err.println(a);
        if (a != null) {
            loginService.login(a);
            mv.setViewName("redirect:inicio.html");
        }

        return mv;
    }

    @GetMapping(value = { "/logout.html" })
    public ModelAndView logout() {
        ModelAndView mv = new ModelAndView();
        loginService.logout();
        mv.setViewName("redirect:/login.html");
        return mv;
    }

    @GetMapping(value = { "/inicio.html" })
    public ModelAndView inicio(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Avaliador avaliador = loginService.getAvaliador();
        java.util.List<Trabalho> trabalhos = repTrab.findAllByAreaConhecimento(avaliador.getAreaConhecimento());
        mv.addObject("avaliador", avaliador);
        mv.addObject("trabalhos", trabalhos);
        mv.addObject("avaliacoes", repRev.findAll());
        java.util.List<Revisao> revisoes = repRev.findAll();
        mv.addObject("revisoes", revisoes);
        mv.setViewName("inicio");
        return mv;
    }

    

    @GetMapping("avaliadores-lista.html")
    public ModelAndView avaliadores(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("avaliadores",rep.findAll());
        return mv;
    }

    @GetMapping("avaliadores-editar/{id}.html")
    public ModelAndView areaEditar(@PathVariable Long id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("avaliador", rep.getClass());
        mv.setViewName("avaliadores-editar");
        return mv;
    }

    @GetMapping( "/novoavaliador.html")
    public ModelAndView avaliadorCadastrar()
    {
        Avaliador avaliador = new Avaliador();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliadores-cadastrar");
        mv.addObject("avaliador", avaliador);
        mv.addObject("areas", reparea.findAll());
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
        mv.setViewName("redirect:/");
       return mv;
       
    }


}
