package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.CategoryRepository;
import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;
import it.contrader.model.Tool;

@Service
public class CategoryService extends AbstractService<Category,CategoryDTO> {
	
	public CategoryDTO findByToolAndNameAndDescription(Tool tool, String name, String description) {
		return converter.toDTO(((CategoryRepository)repository).findByToolAndNameAndDescription(tool, name, description));
	}

}
