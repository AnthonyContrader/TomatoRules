package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ToolRepository;
import it.contrader.dto.ToolDTO;
import it.contrader.model.Tool;

@Service
public class ToolService extends AbstractService<Tool, ToolDTO> {

	public ToolDTO findByNameAndDescription(String name, String description) {
		return converter.toDTO(((ToolRepository)repository).findByNameAndDescription(name, description));
	}

}
