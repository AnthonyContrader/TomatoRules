package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.ToolDTO;
import it.contrader.model.Tool;

@Component
public class ToolConverter extends AbstractConverter<Tool, ToolDTO> {

	@Override
	public Tool toEntity(ToolDTO toolDTO) {
		Tool tool = null;
		if (toolDTO != null) {
			tool = new Tool(toolDTO.getId(), toolDTO.getName(), toolDTO.getDescription());			
		}
		return tool;
	}

	@Override
	public ToolDTO toDTO(Tool tool) {
		ToolDTO toolDTO = null;
		if (tool != null) {
			toolDTO = new ToolDTO(tool.getId(), tool.getName(), tool.getDescription());
			
		}
		return toolDTO;
	}
}
