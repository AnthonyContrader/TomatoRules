package it.contrader.service;

import it.contrader.converter.ActivityConverter;
import it.contrader.dao.ActivityDAO;
import it.contrader.dto.ActivityDTO;
import it.contrader.model.Activity;

/**
 * 
 * @author Angelo
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class ActivityService extends AbstractService<Activity, ActivityDTO> {
	
	//Istanzio DAO e Converter specifici
	public ActivityService() {
		this.dao = new ActivityDAO();
		this.converter = new ActivityConverter();
	}

}
