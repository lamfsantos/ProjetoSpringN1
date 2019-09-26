package br.edu.ifms.ProjetoN1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.ProjetoN1.model.CarroModel;

public interface CarroRepository extends JpaRepository<CarroModel, Long> {
	CarroModel findByPlaca(String placa);
	
}
