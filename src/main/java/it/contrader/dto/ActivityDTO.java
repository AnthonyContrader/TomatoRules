package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActivityDTO {
	
	private Long id;
	
	private String name;
	
	private Long time;
	

}
