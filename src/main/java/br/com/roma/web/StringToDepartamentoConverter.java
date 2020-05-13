package br.com.roma.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.roma.domain.Departamento;
import br.com.roma.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String,Departamento> {

	@Autowired	
	private DepartamentoService service;

	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {
			return null;
			
		}
		Long id = Long.valueOf(text);
		return service.busrcarPorId(id);
	}
	
	
}
