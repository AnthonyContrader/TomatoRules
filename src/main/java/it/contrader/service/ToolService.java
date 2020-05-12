package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.ToolConverter;
import it.contrader.dao.ToolRepository;
import it.contrader.dto.ToolDTO;
import it.contrader.model.Tool;

@Service
public class ToolService extends AbstractService<Tool, ToolDTO> {

	@Autowired
	private ToolConverter converter;
	@Autowired
	private ToolRepository repository;

//	public ToolDTO findByName(String name) {
//		return converter.toDTO(repository.findByName(name));
//	}

}
