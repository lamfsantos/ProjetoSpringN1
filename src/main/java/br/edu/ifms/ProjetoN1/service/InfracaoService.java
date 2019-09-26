package br.edu.ifms.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.ProjetoN1.model.InfracaoModel;
import br.edu.ifms.ProjetoN1.repository.InfracaoRepository;

@Service
public class InfracaoService {
	@Autowired //é responsável por dar new automaticamente e não vai dar NullException
	private InfracaoRepository infracoes;
	
	public List<InfracaoModel> buscarTodos(){
		return infracoes.findAll();
	}
	
	public void salvar(InfracaoModel infracao) {
		infracoes.save(infracao);
	}
	
	public InfracaoModel procurar(long id) {
		return infracoes.getOne(id);
	}
	
	public void excluir(long id) {
		infracoes.deleteById(id);
	}
}
