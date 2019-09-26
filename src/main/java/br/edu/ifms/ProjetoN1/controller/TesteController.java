package br.edu.ifms.ProjetoN1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {
	
	@GetMapping("/teste")
	public String testar() {
		return "PrimeiroTeste";
	}
	
	@GetMapping("/teste2")
	public String testarComBootstrap() {
		return "SegundoTeste";
	}
}
