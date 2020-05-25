package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ActivityDTO;

import it.contrader.model.Activity;

@Component
public class ActivityConverter extends AbstractConverter<Activity, ActivityDTO> {
	
	@Override
	public Activity toEntity(ActivityDTO activityDTO) {
		Activity activity = null;
		if (activityDTO != null) {
			activity = new Activity(activityDTO.getCategory(), activityDTO.getTool(),
			activityDTO.getId(), activityDTO.getName(), activityDTO.getTime());
		}
		return activity;
	}
	
	@Override
	public ActivityDTO toDTO(Activity activity) {
		ActivityDTO activityDTO = null;
		if (activity != null) {
			activityDTO = new ActivityDTO(activity.getCategory(), activity.getTool(), 
			activity.getId(), activity.getName(), activity.getTime());
			
		}
		return activityDTO;
	}

}