package it.contrader.view.activity;

import it.contrader.controller.Request;

import it.contrader.dto.ActivityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Angelo
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class ActivityReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";
			
	public ActivityReadView() {
	}
	
	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L
	 * il metodo è vuoto
	 * 
	 * Altrimenti se arriva con un activity nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra l'activity. In questo caso torna all' ActivityView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			ActivityDTO activity = (ActivityDTO) request.get("activity");
			System.out.println(activity);
			MainDispatcher.getInstance().callView("Activity", null);		
		}
	}
	
	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'utente");
		id = Integer.parseInt(getInput());
	}
	
	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il  Disparcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Activity", "doControl", request);
	}
	
}
