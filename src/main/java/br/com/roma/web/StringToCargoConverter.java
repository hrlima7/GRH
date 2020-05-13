package br.com.roma.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.roma.domain.Cargo;
import br.com.roma.domain.Departamento;
import br.com.roma.service.CargoService;

@Component
public class StringToCargoConverter implements Converter<String,Cargo> {

	@Autowired	
	private CargoService service;

	@Override
	public Cargo convert(String text) {
		if(text.isEmpty()) {
			return null;
			
		}
		Long id = Long.valueOf(text);
		return service.busrcarPorId(id);
	}
	
	
}
