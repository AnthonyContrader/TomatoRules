package it.contrader.view.activity;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ActivityInsertView extends AbstractView{
	private Request request;
	
	private String name;
	private String time;
	private final String mode = "INSERT";
	
	public ActivityInsertView() {
	}
	
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione 
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine. \n");
			MainDispatcher.getInstance().callView("Activity", null);	
		}
	}
	
	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci name:");
		name = getInput();
		System.out.println("Inserisci time:");
/*!*/	time = getInput();
	}
	
	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("time", time);
		request.put("mode", mode);	
		MainDispatcher.getInstance().callAction("Activity", "doControl", request);
	}
	

}
