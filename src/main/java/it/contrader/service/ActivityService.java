package it.contrader.service;

import java.util.List;


import it.contrader.converter.ActivityConverter;
import it.contrader.dao.ActivityDAO;
import it.contrader.dto.ActivityDTO;

/**
 * 
 * @author Angelo
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della classe AbstractService. Pertanto la classe risultam meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class ActivityService {
	
	private ActivityDAO activityDAO;
	private ActivityConverter activityConverter;
	
	//Istanzio DAO e Converter specifici.
	public ActivityService() {
		this.activityDAO = new ActivityDAO();
		this.activityConverter = new ActivityConverter();
	}
	
	
	public List<ActivityDTO> getAll() {
		// Ottiene una lista di entità e la restringe
		return activityConverter.toDTOList(activityDAO.getAll());
	}
	
	
	public ActivityDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return activityConverter.toDTO(activityDAO.read(id));	
	}
	
	
	public boolean insert(ActivityDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return activityDAO.insert(activityConverter.toEntity(dto));
	}
	
	
	public boolean update(ActivityDTO dto) {
		// Converte un activityDTO in entità e lo passa all'activityDAO per la modifica
		return activityDAO.update(activityConverter.toEntity(dto));
	}
	
	
	public boolean delete(int id) {
		// Questo metodo chiama direttamente il DAO 
		return activityDAO.delete(id);
	}

}
