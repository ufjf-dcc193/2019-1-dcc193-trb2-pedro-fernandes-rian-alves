package br.ufjf.dcc193.trabalho2.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import br.ufjf.dcc193.trabalho2.model.Revisao;
import br.ufjf.dcc193.trabalho2.model.enums.Status;
import br.ufjf.dcc193.trabalho2.repository.RevisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc193.trabalho2.model.Avaliador;
import br.ufjf.dcc193.trabalho2.model.Trabalho;
import br.ufjf.dcc193.trabalho2.repository.TrabalhoRepository;
import br.ufjf.dcc193.trabalho2.service.LoginService;

@Controller
public class RevisaoController {
    @Autowired
    TrabalhoRepository repTrab;

    @Autowired
    LoginService loginService;

    @Autowired
    RevisaoRepository rep;

    @GetMapping("revisao/{id}")
    public ModelAndView revisao(HttpSession session, @PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        Optional<Trabalho> trabalho = repTrab.findById(id);
        Avaliador avaliador = loginService.getAvaliador();
        Revisao revisao = new Revisao();
        mv.addObject("revisao", revisao);
       mv.addObject("avaliador", avaliador);
       mv.addObject("trabalho", trabalho.get());
       mv.addObject("status", Status.getValues());
       mv.setViewName("revisao");
       return mv;
   }
  

   @PostMapping("/revisao.html")
   public ModelAndView revisaoPost (Revisao revisao){
       rep.save(revisao);
       return new ModelAndView("redirect:inicio.html");
   }

   @PostMapping("/revisao/pular.html")
    public ModelAndView pularPost(Revisao revisao){
        revisao.setStatus(Status.IMPEDIDO);
        rep.save(revisao);
        return new ModelAndView("redirect:inicio.html");
   }

   @PostMapping("revisao/revisar-depois.html")
   public ModelAndView revisarDepoisPost(Revisao revisao){
       revisao.setStatus(Status.AFAZER);
       rep.save(revisao);
       return new ModelAndView("redirect:inicio.html");
   }
}
