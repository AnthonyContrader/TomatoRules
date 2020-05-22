package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Tool;
import it.contrader.model.Category;


@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Tool findByTool(Tool tool);
	
	Category findByToolAndNameAndDescription(Tool tool, String name, String description);

}
