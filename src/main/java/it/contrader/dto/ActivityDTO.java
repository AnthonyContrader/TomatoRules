package it.contrader.dto;

import it.contrader.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActivityDTO {
	
	private Category category;
	
	private Long id;
	
	private String name;
	
	private Long time;
	

}
