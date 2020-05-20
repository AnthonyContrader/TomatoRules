package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ActivityRepository;
import it.contrader.dto.ActivityDTO;
import it.contrader.model.Activity;

@Service
public class ActivityService extends AbstractService<Activity,ActivityDTO> {
	
	public ActivityDTO findByNameAndTime(String name, Long time) {
		return converter.toDTO(((ActivityRepository)repository).findByNameAndTime(name, time));
	}
}
