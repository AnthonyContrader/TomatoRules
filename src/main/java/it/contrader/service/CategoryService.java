package it.contrader.service;

import java.util.List;


import it.contrader.converter.CategoryConverter;
import it.contrader.dao.CategoryDAO;
import it.contrader.dto.CategoryDTO;

public class CategoryService {

	private CategoryDAO categoryDAO;
	private CategoryConverter categoryConverter;
	
	//Istanzio DAO e Converter specifici.
	public CategoryService(){
		this.categoryDAO = new CategoryDAO();
		this.categoryConverter = new CategoryConverter();
	}
	
	public List<CategoryDTO> getAll() {
		//Ottiene una lista di entità e le restituisce convertendole in DTO
		return categoryConverter.toDTOList(categoryDAO.getAll());
	}
	
	public CategoryDTO read(int id) {
		// Ottiene l'entità (Category e la restituisce convertendola in DTO
		return categoryConverter.toDTO(categoryDAO.read(id));
	}
	
	public boolean insert(CategoryDTO dto) {
		// Converte una categoryDTO in entità e la passa alla categoryDAO per l'inserimento
		return categoryDAO.insert(categoryConverter.toEntity(dto));
	}
	
	public boolean update(CategoryDTO dto) {
		// Converte una categoryDTO in entità e la passa alla categoryDAO per la modifica
		return categoryDAO.update(categoryConverter.toEntity(dto));
	}
	
	public boolean delete(int id) {
		//Questo metodo chiama direttamente il DAO
		return categoryDAO.delete(id);	
	}
	
}
