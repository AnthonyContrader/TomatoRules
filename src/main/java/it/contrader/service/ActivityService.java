package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ActivityConverter;
import it.contrader.dao.ActivityRepository;
import it.contrader.dto.ActivityDTO;
import it.contrader.model.Activity;
import it.contrader.model.Category;

@Service
public class ActivityService extends AbstractService<Activity, ActivityDTO> {

	@Autowired
	private ActivityConverter converter;
	@Autowired
	private ActivityRepository repository;

	public ActivityDTO findByCategoryAndNameAndTime(Category category, String name, Long time) {
		return converter.toDTO(repository.findByCategoryAndNameAndTime(category, name, time));
	}

}


