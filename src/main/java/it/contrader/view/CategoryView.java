package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;

//Si osservi che alla View arrivano solo oggetti di tipo DTO!
public class CategoryView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public CategoryView() {
		
	}

	//Mostra la lista delle categorie
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione categorie ----------------\n");
			System.out.println("ID\tNome\tDescrizione");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<CategoryDTO> categories = (List<CategoryDTO>) request.get("categories");
			for (CategoryDTO c: categories)
				System.out.println(c);
			System.out.println();
		}
	}
	
	/**
	 * Chiedo alla categoria un input (lettera da tastiera) per la choice (vedi CategoryController).
	 * Metto la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("           Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		this.choice = getInput();
		
		
	}
	
	/**
	 * Impacchetto la request e la mando alla CategoryController.
	 */
	@Override
	public void submit () {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Category", "doControl", this.request);
	}
	 
}
