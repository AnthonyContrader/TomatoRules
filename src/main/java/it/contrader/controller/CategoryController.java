package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.CategoryDTO;
import it.contrader.service.CategoryService;
import it.contrader.model.Tool;
import it.contrader.service.ToolService;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController extends AbstractController<CategoryDTO> {

	@Autowired
	private CategoryService categoryService;
	
}
