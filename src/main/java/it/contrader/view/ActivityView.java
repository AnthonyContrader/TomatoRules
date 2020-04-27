package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ActivityDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Angelo
 *
 * Si ossevi che alla View arrivano solo oggetti di tipo DTO
 */
public class ActivityView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public ActivityView() {
		
	}
	
	/**
	 * Mostra la lista utenti 
	 */ 
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione utenti ----------------\n");
/*!*/		System.out.println("ID\tNome\tTempo");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ActivityDTO> activitys = (List<ActivityDTO>) request.get("activitys");
/*!*/		for (ActivityDTO a: activitys)
				System.out.println(a);
			System.out.println();	
		}
	}
	
	/**
	 * Chiede all'utente un input ( lettera da tastiera) per la choice (vedi ActivityController)
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		this.choice = getInput();
		
		
	}
	
	/**
	 * Impacchetta la request e la manda all'ActivityController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Activity", "doControl", this.request);
	}

}
