package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.ToolDTO;
import it.contrader.model.Tool;

public class ToolConverter implements Converter<Tool, ToolDTO> {

	// Da entita' a DTO
	@Override
	public ToolDTO toDTO(Tool tool) {
		ToolDTO toolDTO = new ToolDTO(tool.getId(), tool.getName(), tool.getDescription());
		return toolDTO;
	}

	// Da DTO a entita'
	@Override
	public Tool toEntity(ToolDTO toolDTO) {
		Tool tool = new Tool(toolDTO.getId(), toolDTO.getName(), toolDTO.getDescription());
		return tool;
	}

	// Conversione delle liste
	@Override
	public List<ToolDTO> toDTOList(List<Tool> toolList) {
		List<ToolDTO> toolDTOList = new ArrayList<ToolDTO>();
		for(Tool tool : toolList) {
			toolDTOList.add(toDTO(tool));
		}
		return toolDTOList;
	}
}
