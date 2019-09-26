package br.edu.ifms.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.ProjetoN1.model.ItemModel;
import br.edu.ifms.ProjetoN1.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired //é responsável por dar new automaticamente e não vai dar NullException
	private ItemRepository itens;
	
	public List<ItemModel> buscarTodos(){
		return itens.findAll();
	}
	
	public void salvar(ItemModel item) {
		itens.save(item);
	}
	
	public ItemModel procurar(long id) {
		return itens.getOne(id);
		
	}
	
	public void excluir(long id) {
		itens.deleteById(id);
	}
}
