package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ActivityDTO;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ActivityService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController extends AbstractController<ActivityDTO>{
	
	@Autowired
	private ActivityService activityService;

}
