package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.CategoryRepository;
import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

@Service
public class CategoryService extends AbstractService<Category,CategoryDTO> {
	
	public CategoryDTO findByNameAndDescription(String name, String description) {
		return converter.toDTO(((CategoryRepository)repository).findByNameAndDescription(name, description));
	}

}
