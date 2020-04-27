package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ActivityDTO;
import it.contrader.model.Activity;


public class ActivityConverter {
	
	public ActivityDTO toDTO(Activity activity) {
		ActivityDTO activityDTO = new ActivityDTO(activity.getId(), activity.getName(), activity.getTime());
		return activityDTO;		
	}
	
	
	
	public Activity toEntity(ActivityDTO activityDTO) {
		Activity activity = new Activity(activityDTO.getId(), activityDTO.getName(), activityDTO.getTime());
		return activity;
	}
	
	
	/**
	 * Metodo per convertire le liste di Activity in liste ActivityDTO
	 * @param activityDTO
	 * @return
	 */
	
	public List<ActivityDTO> toDTOList(List<Activity> activityList) {
		//Crea una lista vuota
		List<ActivityDTO> activityDTOList = new ArrayList<ActivityDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno ad uno
		for(Activity activity : activityList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge alla lista di DTO
			activityDTOList.add(toDTO(activity));
		}
		return activityDTOList;
	}
	
	

}
