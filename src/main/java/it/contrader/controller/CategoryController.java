package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CategoryService;

//Nel Controller compaiono solo oggetti del DTO e non del Model!

public class CategoryController implements Controller {

	//Definisco il pacchetto di vista category.
	private static String sub_package = "category.";
	
	private CategoryService categoryService;
	
	//Costruisco un oggetto di tipo Category Service per poterne usare i metodi
	public CategoryController() {
		this.categoryService = new CategoryService();
		
	}
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estraggo dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		//Definisco i campi della classe (serviranno sempre, tanto vale definirli una volta sola
		int id;
		String name;
		String description;
		
		switch (mode) {
		
		//Arrivo qui dalla CategoryReadView. Invoca il Service con il parametro id e invia alla CateryReadView una category da mostrare
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			CategoryDTO categoryDTO = categoryService.read(id);
			request.put("category", categoryDTO);
			MainDispatcher.getInstance().callView(sub_package + "CategoryRead", request);
			break;
		
		/*Arrivo qui dalla CategoryInsertView. Estraggo i parametri da inserire e chiamo il
		 * service per inserire una category con questi parametri
		 */
		case "INSERT":
			name = request.get("name").toString();
			description = request.get("description").toString();
			
			//Costruiscol'oggetto category da inserire
			CategoryDTO categorytoinsert = new CategoryDTO(name, description);
			//Invoco il service
			categoryService.insert(categorytoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimando alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "CategoryInsert", request);
			break;
			
		/*Arrivo qui dalla CategoryDeleteView. Estraggo l'id della category da cancellare
		* e lo passo al service
		*/
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiamo il service
			categoryService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CategoryDelete", request);
			break;
			
		//Arrivo qui dalla CategoryUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			description = request.get("description").toString();
			CategoryDTO categorytoupdate = new CategoryDTO(name, description);
			categorytoupdate.setId(id);
			categoryService.update(categorytoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CategoryUpdate", request);
			break;
			
		case "CATEGORYLIST":
			List<CategoryDTO> categoriesDTO = categoryService.getAll();
			//Impacchetto la request con la lista delle category
			request.put("categories", categoriesDTO);
			MainDispatcher.getInstance().callView("Category", request);
			break;
			
		/*Eseguo uno switch sulla base del comando inserito dall'utente e reindirizza
		 * tramite il Dispatcher alla View specifica per ogni operazione
		 * con REQUEST NULL (vedi una View specifica)
		 */
		case "GETCHOICE":
			
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CategoryRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CategoryInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CategoryUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CategoryDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
				
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
	
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
	}	
	
}



