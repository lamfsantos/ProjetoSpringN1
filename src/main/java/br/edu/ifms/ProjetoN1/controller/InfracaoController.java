package br.edu.ifms.ProjetoN1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.ProjetoN1.model.InfracaoModel;
import br.edu.ifms.ProjetoN1.service.InfracaoService;

@Controller 
public class InfracaoController {
	
	@Autowired 
	private InfracaoService infracaoService;
	
	@GetMapping("/infracoes")
	public ModelAndView listaInfracoes() {
		ModelAndView mv = new ModelAndView("ListaInfracoes");
		
		mv.addObject("infracoes", infracaoService.buscarTodos());
		mv.addObject(new InfracaoModel());
		
		return mv;
	}
	
	@PostMapping("/infracoes")
	public String salvar(InfracaoModel infracao) {
		infracaoService.salvar(infracao);
		return "redirect:/infracoes";
	}
	
	@GetMapping("/edInfracao/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("EditaInfracao");
		modelAndView.addObject(infracaoService.procurar(id));
		return modelAndView;
	}
	
	@GetMapping("/exInfracao/{id}")
	public String excluirDireto(@PathVariable("id") long id){
		infracaoService.excluir(id);
		return "redirect:/infracoes";
	}
	
	@GetMapping("/exxInfracao/{id}")
	public ModelAndView excluir(@PathVariable("id") long id){
		ModelAndView modelAndView = new ModelAndView("ExcluiInfracao");
		modelAndView.addObject(infracaoService.procurar(id));
		return modelAndView;
	}
	
	@PostMapping("/exxInfracao/{id}")
	public String excluirInfracao(@PathVariable("id") long id){
		infracaoService.excluir(id);
		return "redirect:/infracoes";
	}
	
}









