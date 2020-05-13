package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.CategoryConverter;
import it.contrader.dao.CategoryRepository;
import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;
import it.contrader.model.Tool;

@Service
public class CategoryService extends AbstractService<Category, CategoryDTO> {
	
	@Autowired
	private CategoryConverter converter;
	@Autowired
	private CategoryRepository repository;
	
	public CategoryDTO findByToolAndNameAndDescription(Tool tool, String name, String description) {
		return converter.toDTO(repository.findByToolAndNameAndDescription(tool, name, description));
	}

}
