package br.ufjf.dcc193.trabalho2.controller;

import br.ufjf.dcc193.trabalho2.model.AreaConhecimento;
import br.ufjf.dcc193.trabalho2.repository.AreaConhecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Controller
public class AreaConhecimentoController {

    @Autowired
    private AreaConhecimentoRepository rep;

    @GetMapping("areas.html")
    public ModelAndView areasConhecimento() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("areasConhecimento");
        List<AreaConhecimento> areasConhecimento = rep.findAll();
        mv.addObject("areasConhecimento", areasConhecimento);
        return mv;
    }

    @GetMapping("areas/{id}.html")
    public ModelAndView areaConhecimento(@PathVariable Long id)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("area");
        Optional<AreaConhecimento> areaConhecimento = rep.findById(id);
        mv.addObject("areaConhecimento",areaConhecimento);
        return mv;
    }

   
    @GetMapping( "/areas-cadastrar.html")
    public ModelAndView areaConhecimento()
    {
        AreaConhecimento area = new AreaConhecimento();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("area-cadastrar");
        mv.addObject("area", area);
        return mv;
    }

    @PostMapping(value = "/criarArea.html")
    public ModelAndView areaConhecimentoSalvar(@Valid AreaConhecimento area, BindingResult binding){
    
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("area-cadastrar");
            mv.addObject("area", area);
            return mv;
        }
        rep.save(area);
        mv.setViewName("redirect:principal.html");
        return mv;
       
    }

    @PostMapping("areas-cadastrar.html")
    public RedirectView areaCadastrarPost(AreaConhecimento areaConhecimento){
        rep.save(areaConhecimento);
        return new RedirectView("/areas.html?cadastrado=true");
    }

    @GetMapping("/areas-editar/{id}.html")
    public ModelAndView areaAlterar(@PathVariable Long id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("area",rep.getOne(id));
        mv.setViewName("area-editar");
        return mv;
    }
    @PostMapping("/areas-editar.html")
    public RedirectView areaAlterarPost(AreaConhecimento area){
        rep.save(area);
        return new RedirectView("/areas.html?alterado=true");
    }

    @GetMapping("/areas-deletar/{id}.html")
    public RedirectView areaDeletar(@PathVariable Long id){
        rep.deleteById(id);
        return new RedirectView("/areas.html?deletado=true");
    }


}
