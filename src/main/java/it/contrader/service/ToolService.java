package it.contrader.service;

import it.contrader.converter.ToolConverter;
import it.contrader.dao.ToolDAO;
import it.contrader.dto.ToolDTO;
import it.contrader.model.Tool;

public class ToolService extends AbstractService<Tool, ToolDTO> {

	// Apertura istanza di DAO  e Converter specifici
	public ToolService() {
		this.dao = new ToolDAO();
		this.converter = new ToolConverter();
	}
}
