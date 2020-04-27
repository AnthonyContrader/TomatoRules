package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class CategoryUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private String name;
	private String description;
	private final String mode = "UPDATE";
	
	public CategoryUpdateView() {	
	}
	
	/**
	 * Se la request non è nulla ovvero se si arriva dalla mode UPDATE del controller)
	 * mostra l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	/**
	 * Chiede all'utente di inserire gli attributi della categoria da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della Categoria:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome della Categoria:");
			name = getInput();
			System.out.println("Inserisci descrizione della Categoria:");
			description = getInput();
		} catch (Exception e) {
			System.out.println("Pippo:");
			
		}
	}
	
	/**
	 * Impacchetto la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}
}
