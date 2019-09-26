package br.edu.ifms.ProjetoN1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.ProjetoN1.model.ItemModel;
import br.edu.ifms.ProjetoN1.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired 
	private ItemService itemService;
	
	@GetMapping("/itens")
	public ModelAndView listaItens() {
		ModelAndView mv = new ModelAndView("ListaItens");
	
		mv.addObject("itens", itemService.buscarTodos());
		mv.addObject(new ItemModel());
		
		return mv;
	}

	@PostMapping("/itens")
	public String salvar(ItemModel item) {
		itemService.salvar(item);
		return "redirect:/itens";
	}
	
	@GetMapping("/edItem/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("EditaItem");
		modelAndView.addObject(itemService.procurar(id));
		return modelAndView;
	}
	
	@GetMapping("/exItem/{id}")
	public String excluirItem(@PathVariable("id") long id){
		itemService.excluir(id);
		return "redirect:/itens";
	}

}










