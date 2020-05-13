package br.com.roma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.roma.dao.FuncionarioDao;
import br.com.roma.domain.Funcionario;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao dao;
	
	@Override
	public void save(Funcionario funcionario) {
		dao.save(funcionario);
		
	}

	@Override
	public void update(Funcionario funcionario) {
		dao.update(funcionario);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		
		
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Funcionario> busacar() {
		
		return dao.findAll();
	}

	
	
	
}
