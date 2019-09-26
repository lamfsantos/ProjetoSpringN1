package br.edu.ifms.ProjetoN1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.ProjetoN1.model.MultaModel;
import br.edu.ifms.ProjetoN1.service.InfracaoService;
import br.edu.ifms.ProjetoN1.service.MultaService;

@Controller 
public class MultaController {
	
	@Autowired 
	private MultaService multaService;
	
	@Autowired 
	private InfracaoService infracaoService;
	
	@GetMapping("/multas")
	public ModelAndView listaMultas() {
		ModelAndView mv = new ModelAndView("ListaMultas");
		mv.addObject("infracoes", infracaoService.buscarTodos());
		mv.addObject("multas", multaService.buscarTodos());
		mv.addObject(new MultaModel());
		
		return mv;
	}
	
	@PostMapping("/multas")
	public String salvar(MultaModel multa) {
		multaService.salvar(multa);
		return "redirect:/multas";
	}
	
	@GetMapping("/edMulta/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("EditaMulta");
		modelAndView.addObject(multaService.procurar(id));
		modelAndView.addObject("infracoes", infracaoService.buscarTodos());
		modelAndView.addObject("multas", multaService.buscarTodos());
		return modelAndView;
	}
	
	@GetMapping("/exMulta/{id}")
	public ModelAndView excluir(@PathVariable("id") long id){
		ModelAndView modelAndView = new ModelAndView("ExcluiMulta");
		modelAndView.addObject(multaService.procurar(id));
		return modelAndView;
	}
	
	@PostMapping("/exMulta/{id}")
	public String excluirDireto(@PathVariable("id") long id){
		multaService.excluir(id);
		return "redirect:/multas";
	}
}
