package br.com.roma.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARGO")
public class Cargo extends AbstractEntity<Long> {

	
	private static final long serialVersionUID = 1L;

	@Column(name="nm_cargo",nullable= false,unique= true, length = 70 )
	private String nome;
	
	@ManyToOne()
	@JoinColumn(name="id_departamento_fk")
	private Departamento departamento;

	@OneToMany(mappedBy = "cargo")	
	private List<Funcionario> funcionarios ;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
}