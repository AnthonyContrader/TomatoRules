package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.ToolDTO;
import it.contrader.service.ToolService;

@RestController
@RequestMapping("/tool")
@CrossOrigin(origins = "http://localhost:4200")
public class ToolController extends AbstractController<ToolDTO> {

	@Autowired
	private ToolService toolService;

}
