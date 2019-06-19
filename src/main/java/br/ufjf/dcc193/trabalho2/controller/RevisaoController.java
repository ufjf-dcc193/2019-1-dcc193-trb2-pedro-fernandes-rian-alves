package br.ufjf.dcc193.trabalho2.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("revisao/{id}")
    public ModelAndView revisao(HttpSession session, @PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        Optional<Trabalho> trabalho = repTrab.findById(id);
        Avaliador avaliador = loginService.getAvaliador();
      
       mv.addObject("avaliador", avaliador);
       mv.addObject("trabalho", trabalho);
       mv.setViewName("revisao");
       return mv;
   }
}
