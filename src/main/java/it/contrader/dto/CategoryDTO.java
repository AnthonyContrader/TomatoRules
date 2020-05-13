package it.contrader.dto;

import it.contrader.model.Tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDTO {

	private Tool tool;
	
	private Long id;

	private String name;

	private String description;

	
	
	
	
	
}
