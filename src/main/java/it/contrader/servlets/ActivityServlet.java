package it.contrader.servlets;

import java.util.List;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.ActivityDTO;
import it.contrader.dto.CategoryDTO;
import it.contrader.service.Service;
import it.contrader.service.ActivityService;
import it.contrader.service.CategoryService; 


public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ActivityServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ActivityDTO> service = new ActivityService();
		List<ActivityDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
		getCategory(request);
	}
	public void getCategory(HttpServletRequest request) {
		Service<CategoryDTO> serviceCategory = new CategoryService();
		List<CategoryDTO>listDTO = serviceCategory.getAll();
		request.setAttribute("listCategory", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ActivityDTO> service = new ActivityService();
		Service<CategoryDTO> categoryservice = new CategoryService();
		String mode = request.getParameter("mode");
		ActivityDTO dto;
		CategoryDTO categorydto;
		int id;
		int rest;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "ACTIVITYLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/activity/activitymanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			rest = dto.getRest();
			categorydto = categoryservice.read(rest); 
			request.setAttribute("dto", dto);
			request.setAttribute("categorydto", categorydto);
			getCategory(request);
			
			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/activity/readactivity.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/activity/updateactivity.jsp").forward(request, response);
			
			break;
			
		case "INSERT":
			String name = request.getParameter("name").toString();
		    int time = Integer.parseInt(request.getParameter("time").toString());
		    rest = Integer.parseInt(request.getParameter("rest").toString());
			dto = new ActivityDTO (name, time, rest);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/activity/activitymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			time = Integer.parseInt(request.getParameter("time"));
			rest = Integer.parseInt(request.getParameter("rest"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ActivityDTO (id, name, time, rest);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/activity/activitymanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/activity/activitymanager.jsp").forward(request, response);
			break;
		}
	}
 
}
