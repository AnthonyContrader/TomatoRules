package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Category;
import it.contrader.model.Tool;
import it.contrader.model.Activity;


@Repository
@Transactional
public interface ActivityRepository extends CrudRepository<Activity, Long> {
	
	Category findByCategory(Category category);
	
	Tool findByTool(Tool tool);
	
	Activity findByCategoryAndToolAndNameAndTime(Category category, Tool tool, String name, Long time);

}
