package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ActivityDTO;
import it.contrader.service.ActivityService;
import it.contrader.model.Category;
import it.contrader.model.Tool;
import it.contrader.service.CategoryService;
import it.contrader.service.ToolService;

@RestController
@RequestMapping("/activity")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController extends AbstractController<ActivityDTO>{
	
	@Autowired
	private ActivityService activityService;
		
}
