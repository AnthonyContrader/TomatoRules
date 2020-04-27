package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ActivityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ActivityService;

/**
 * 
 * @author Angelo
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class ActivityController implements Controller {
	
	/**
	 * definisce il pacchetto di vista activity.
	 */
	private static String sub_package = "activity.";
	
	private ActivityService activityService;
	/**
	 * Costruisce un oggetto di tipo ActivityService per poterne usare  i metodi
	 */
	public ActivityController() {
		this.activityService = new ActivityService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * ( che riceve dalle view specifiche e può essere la richiesta di una
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad un CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice"); 
		
		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String name;
		int time;
		
		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			ActivityDTO activityDTO = activityService.read(id);
			request.put("activity", activityDTO);
			MainDispatcher.getInstance().callView(sub_package + "ActivityRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			name = request.get("name").toString();
	/*!*/	time = Integer.parseInt(request.get("time").toString());
	
			//costruisce l'oggetto activity da inserire
			ActivityDTO activitytoinsert = new ActivityDTO(name, time);
			//invoca il service
			activityService.insert(activitytoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "ActivityInsert" , request);
			break;
			
		//Arriva qui dalla ActivityDeleteView. Estrae l'id utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			// Qui chiama il service
			activityService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ActivityDelete" , request);
			break;
			
		// Arriva qui dalla ActivityUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
/*!*/		time = Integer.parseInt(request.get("time").toString());
			ActivityDTO activitytoupdate = new ActivityDTO(name, time);
			activitytoupdate.setId(id);
			activityService.update(activitytoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ActivityUpdate" , request);
			break;
		//Arriva qui dalla ActivityView. Invoca il Service e invia alla ActivityView il risultato da mostrare
		case "ACTIVITYLIST":
			List<ActivityDTO> activitysDTO = activityService.getAll();
			//Impacchetta la request con la lista dell'activity
			request.put("activity", activitysDTO);
			MainDispatcher.getInstance().callView("Activity" , request);
			break;
		
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL ( vedi una View specifica)
		case "GETCHOICE":
			
				//toUppreCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ActivityRead" , null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ActivityInsert" , null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ActivityUpdate" , null);
				break;
			
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ActivityDelete" , null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login" , null);
				break;
				
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin" , null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login" , null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login" , null);	
		}
	}
	
	
	

}
