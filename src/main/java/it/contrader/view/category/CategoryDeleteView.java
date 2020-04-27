package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryDeleteView extends AbstractView {
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public CategoryDeleteView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller)
	 * mostra l'esito dell'operazione 
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione Categoria andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	/**
	 * Chiedo all'utente di inserire l'ID della Categoria da cancellare
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci ID della Categoria:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * Impacchetto la request con l'ID della Categoria da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id",  id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}
}
