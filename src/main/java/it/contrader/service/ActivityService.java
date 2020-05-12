package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ActivityConverter;
import it.contrader.dao.ActivityRepository;
import it.contrader.dto.ActivityDTO;
import it.contrader.model.Activity;

@Service
public class ActivityService extends AbstractService<Activity, ActivityDTO> {

	@Autowired
	private ActivityConverter converter;
	@Autowired
	private ActivityRepository repository;

	public ActivityDTO findByNameAndTime(String name, Long time) {
		return converter.toDTO(repository.findByNameAndTime(name, time));
	}

}


