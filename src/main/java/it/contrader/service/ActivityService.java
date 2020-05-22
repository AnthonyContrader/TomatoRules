package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ActivityRepository;
import it.contrader.dto.ActivityDTO;
import it.contrader.model.Activity;
import it.contrader.model.Category;

@Service
public class ActivityService extends AbstractService<Activity,ActivityDTO> {
	
	
	public ActivityDTO findByCategoryAndNameAndTime(Category category,String name, Long time) {
		return converter.toDTO(((ActivityRepository)repository).findByCategoryAndNameAndTime(category, name, time));
	}
}
