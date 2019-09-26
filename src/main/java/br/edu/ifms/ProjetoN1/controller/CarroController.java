package br.edu.ifms.ProjetoN1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.ProjetoN1.model.CarroModel;
import br.edu.ifms.ProjetoN1.service.CarroService;

@Controller 
public class CarroController {
	
	@Autowired 
	private CarroService carroService;
	
	@GetMapping("/carros")
	public ModelAndView listaCarros() {
		ModelAndView mv = new ModelAndView("ListaCarros");
		
		mv.addObject("carros", carroService.buscarTodos());
		mv.addObject(new CarroModel());
		
		return mv;
	}

	@PostMapping("/carros")
	public String salvar(CarroModel carro) {
		carroService.salvar(carro);
		return "redirect:/carros";
	}
	
	@GetMapping("/edCarro/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("EditaCarro");
		modelAndView.addObject(carroService.procurar(id));
		return modelAndView;
	}
	
	@GetMapping("/exCarro/{id}")
	public String excluirDireto(@PathVariable("id") long id){
		carroService.excluir(id);
		return "redirect:/carros";
	}
	
	@GetMapping("/exxCarro/{id}")
	public ModelAndView excluir(@PathVariable("id") long id){
		ModelAndView modelAndView = new ModelAndView("ExcluiCarro");
		modelAndView.addObject(carroService.procurar(id));
		return modelAndView;
	}
	
	@PostMapping("/exxCarro/{id}")
	public String excluirCarro(@PathVariable("id") long id){
		carroService.excluir(id);
		return "redirect:/carros";
	}
	
	@GetMapping("/")
	public String principal() {
		return "redirect:/carros";
	}
}