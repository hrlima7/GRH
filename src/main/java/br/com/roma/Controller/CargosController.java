package br.com.roma.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.roma.domain.Cargo;
import br.com.roma.domain.Departamento;
import br.com.roma.service.CargoService;
import br.com.roma.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargosController {

	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private  DepartamentoService departamentoService;
	
	
	@GetMapping("/cadastrar")
	public String  cadastrar(Cargo cargo) {
		
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		
		model.addAttribute("cargos",cargoService.buscarTodos());
		return "/cargo/lista";
		
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo) {
		
		cargoService.salvar(cargo);
	
		return "redirect:/cargos/cadastrar";
			
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamento(){
		return departamentoService.buscarTodos(); 
		
		
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.busrcarPorId(id));
		return "cargo/cadastro";
				
	}
	
	@PostMapping("/editar")
	 public String editar(Cargo cargo) {
		 cargoService.editar(cargo);
		 return "redirect:/cargos/cadastrar";
		 
	 }
	

	
}
