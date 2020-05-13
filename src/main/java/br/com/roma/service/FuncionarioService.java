package br.com.roma.service;

import java.util.List;

import br.com.roma.domain.Funcionario;

public interface FuncionarioService {

	
	void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario buscarPorId(Long id);

    List<Funcionario> busacar();
}
	
	

