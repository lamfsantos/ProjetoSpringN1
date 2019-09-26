package br.edu.ifms.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.ProjetoN1.repository.CarroRepository;
import br.edu.ifms.ProjetoN1.model.CarroModel;

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
}
