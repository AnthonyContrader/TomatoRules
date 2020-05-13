package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ActivityDTO;
import it.contrader.service.ActivityService;
import it.contrader.model.Category;
import it.contrader.model.Tool;
import it.contrader.service.CategoryService;
import it.contrader.service.ToolService;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityService service;
	
	@Autowired
	private CategoryService serviceCategory;
	
	@Autowired
	private ToolService serviceTool;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "activities";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "activities";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateactivity";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("activitytool") Tool activitytool, 
			@RequestParam("category") Category category, 
			@RequestParam("id") Long id, 
			@RequestParam("name") String name,
			@RequestParam("time") Long time) {

		ActivityDTO dto = new ActivityDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setTime(time);
		dto.setActivitytool(activitytool);
		dto.setCategory(category);
		service.update(dto);
		setAll(request);
		return "activities";
		
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("activitytool") Tool activitytool,
			@RequestParam("category") Category category,
			@RequestParam("name") String name,
			@RequestParam("time") Long time) {
		ActivityDTO dto = new ActivityDTO();
		dto.setName(name);
		dto.setTime(time);
		dto.setActivitytool(activitytool);
		dto.setCategory(category);
		service.insert(dto);
		setAll(request);
		return "activities";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readactivity";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listCategory", serviceCategory.getAll());
		request.getSession().setAttribute("listTool", serviceTool.getAll());
	}

}
