package br.com.roma.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.roma.domain.Cargo;
import br.com.roma.domain.Funcionario;
import br.com.roma.domain.UF;
import br.com.roma.service.CargoService;
import br.com.roma.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	
	@Autowired
	FuncionarioService service;
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cadastrar")
	public String  cadastrar(Funcionario funcionario) {
		
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		
		return "/funcionario/lista";
		
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes att) {
		service.save(funcionario);
		//att.addAttribute("funcionario", "Funcionário cadastrado com sucesso");
		
		
		return"redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUfs() {
		return UF.values();
		
		
	}
	
	
	
}
