package it.contrader.view.category;

import it.contrader.controller.Request;

import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Daniele
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class CategoryReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public CategoryReadView() {
	}
	
	/**
	 * Se la request è null (Ovvero quando arriva dal controller con mode GETCHOICE e 
	 * choice L il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con una cateogry nella request (ovvero quando arriva dal controller
	 * con mode READ) mostra la category. In questo caso torna alla CategoryView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			CategoryDTO category = (CategoryDTO) request.get("category");
			System.out.println(category);
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	/**
	 * Chiedo all'utente di inserire l'id della categoria da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della Categoria");
		id = Integer.parseInt(getInput());
	}
	
	/**
	 * Impacchetto una request con l'id della categoria da leggere e la mando al controller
	 * tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}
}