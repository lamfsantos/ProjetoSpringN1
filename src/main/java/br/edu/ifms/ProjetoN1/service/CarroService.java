package br.edu.ifms.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.ProjetoN1.repository.CarroRepository;
import br.edu.ifms.ProjetoN1.model.CarroModel;
import br.edu.ifms.ProjetoN1.model.MultaModel;

@Service
public class CarroService {

	@Autowired //é responsável por dar new automaticamente e não vai dar NullException
	private CarroRepository carros;
	
	public List<CarroModel> buscarTodos(){
		return carros.findAll();
	}
	
	public void salvar(CarroModel carro) {
		carros.save(carro);
	}
	
	public CarroModel procurar(long id) {
		return carros.getOne(id);
	}
	
	public void excluir(long id) {
		carros.deleteById(id);
	}
	
	public int calculaTotalPontos(CarroModel carro) {
		int pontos = 0;
		
		for(MultaModel multa : carro.getMultas()) {
			pontos += multa.getInfracao().getPontos();
		}
		
		return pontos;
	}
	
	public double calculaValorTotal(CarroModel carro) {
		double valor = 0;
		
		for(MultaModel multa : carro.getMultas()) {
			valor += multa.getInfracao().getValor();
		}
		
		return valor;
	}
}
