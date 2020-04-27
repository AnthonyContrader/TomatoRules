package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryInsertView extends AbstractView{

	private Request request;
	
	private String name;
	private String description;
	private final String mode = "INSERT";
	
	public CategoryInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovver se si arriva dalla mode INSERT del controller)
	 * mostra l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento Categoria andata a buon fine.\\n");
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	/**
	 * Chiedo all'utente di inserire gli attributi della categoria da inserire
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci nome della categoria:");
		name = getInput();
		System.out.println("Inserisci descrizione della categoria:");
		description = getInput();
	}
	
	/**
	 * Impacchetto la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}
}
