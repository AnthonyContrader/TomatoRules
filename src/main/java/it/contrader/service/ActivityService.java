package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ActivityRepository;
import it.contrader.dto.ActivityDTO;
import it.contrader.model.Activity;
import it.contrader.model.Tool;

@Service
public class ActivityService extends AbstractService<Activity,ActivityDTO> {
	
	public ActivityDTO findByToolAndNameAndTime(Tool tool, String name, Long time) {
		return converter.toDTO(((ActivityRepository)repository).findByToolAndNameAndTime(tool, name, time));
	}
}
