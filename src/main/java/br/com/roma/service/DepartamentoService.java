package br.com.roma.service;

import java.util.List;
import br.com.roma.domain.Departamento;

public interface DepartamentoService {

	void salvar(Departamento departamento);
	
	void editar (Departamento departamento);
	
	void excluir(Long id );
	
	Departamento busrcarPorId(Long id);
	
	List<Departamento> buscarTodos();

	boolean departamentoTemCargos(Long id);
	
	
	
}
