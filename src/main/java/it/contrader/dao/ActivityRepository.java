package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Category;
import it.contrader.model.Activity;

@Repository
@Transactional
public interface ActivityRepository extends CrudRepository<Activity, Long> {

	Category findByCategory(Category category);
	
	Activity findByCategoryAndNameAndTime(Category category,String name, Long time);

}



