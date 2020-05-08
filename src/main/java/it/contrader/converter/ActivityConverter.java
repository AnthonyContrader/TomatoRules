package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ActivityDTO;
import it.contrader.model.Activity;

/**
 * 
 * @author Angelo
 *
 *Implementando questa interfaccia converter la classe ActivityConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class ActivityConverter implements Converter<Activity, ActivityDTO> {
	
	/**
	 * Crea un oggetto di tipo ActivityDTO e lo riempie con i campi del parametro activity di tipo Activity.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public ActivityDTO toDTO(Activity activity) {
		ActivityDTO activityDTO = new ActivityDTO(activity.getId(), activity.getName(), activity.getTime(), activity.getRest());
		return activityDTO;		
	}
	
	/**
	 * Crea un oggetto di tipo Activity e lo riempie con i campi del parametro activity di tipo ActivityDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo- 
	 */
	@Override
	public Activity toEntity(ActivityDTO activityDTO) {
		Activity activity = new Activity(activityDTO.getId(), activityDTO.getName(), activityDTO.getTime(), activityDTO.getRest());
		return activity;
	}
	
	
	/**
	 * Metodo per convertire le liste di Activity.
	 */
	@Override
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
