package br.com.roma.service;

import java.util.List;

import br.com.roma.domain.Cargo;


public interface CargoService {

	void salvar(Cargo cargo);
	
	void editar (Cargo cargo);
	
	void excluir(Long id );
	
	Cargo busrcarPorId(Long id);
	
	List<Cargo> buscarTodos();
	
	
}
