package br.edu.ifms.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.ProjetoN1.model.MultaModel;
import br.edu.ifms.ProjetoN1.repository.CarroRepository;
import br.edu.ifms.ProjetoN1.repository.MultaRepository;

@Service
public class MultaService {

	@Autowired
	private MultaRepository multas;

	@Autowired
	private CarroRepository carro;

	public List<MultaModel> buscarTodos() {
		return multas.findAll();
	}

	public void salvar(MultaModel multa) {
		multa.setCarro(carro.findByPlaca(multa.getCarro().getPlaca()));
		multas.save(multa);
	}

	public MultaModel procurar(long id) {
		return multas.getOne(id);
	}

	public void excluir(long id) {
		multas.deleteById(id);
	}
}
