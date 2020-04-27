package it.contrader.view.activity;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class ActivityUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private String name;
	private int time;
	private final String mode = "UPDATE";
	
	public ActivityUpdateView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request !=null) {
			System.out.println("Modifica andata a buon fine. \n");
			MainDispatcher.getInstance().callView("Activity", null);
		}
	}
	
	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare 
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inseriscil'id dell'utente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci name");
			name = getInput();
			System.out.println("Inserisci time");
			time = Integer.parseInt(getInput());	
		} catch (Exception e) {
			
		}
	}
	
	
	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("time", time);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Activity", "doControl", request);
	}

}
