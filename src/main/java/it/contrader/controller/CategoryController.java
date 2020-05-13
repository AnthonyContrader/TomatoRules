package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CategoryDTO;
import it.contrader.service.CategoryService;
import it.contrader.model.Tool;
import it.contrader.service.ToolService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@Autowired
	private ToolService serviceTool;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "categories";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "categories";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatecategory";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("tool") Tool tool, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description ) {

		CategoryDTO dto = new CategoryDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setDescription(description);
		dto.setTool(tool);
		service.update(dto);
		setAll(request);
		return "categories";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("tool") Tool tool, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		CategoryDTO dto = new CategoryDTO();
		dto.setName(name);
		dto.setDescription(description);
		dto.setTool(tool);
		service.insert(dto);
		setAll(request);
		return "categories";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readcategory";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listTool", serviceTool.getAll());
	}
	
}
