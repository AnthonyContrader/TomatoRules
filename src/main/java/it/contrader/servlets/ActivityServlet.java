package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ActivityDTO;
import it.contrader.service.Service;
import it.contrader.service.ActivityService;


public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ActivityServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ActivityDTO> service = new ActivityService();
		List<ActivityDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ActivityDTO> service = new ActivityService();
		String mode = request.getParameter("mode");
		ActivityDTO dto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "ACTIVITYLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/activity/activitymanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/activity/readactivity.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/activity/updateactivity.jsp").forward(request, response);
			
			break;
			
		case "INSERT":
			String name = request.getParameter("name").toString();
		    int time = Integer.parseInt(request.getParameter("time").toString());
			dto = new ActivityDTO (name, time);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/activity/activitymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			time = Integer.parseInt(request.getParameter("time"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ActivityDTO (id, name, time);
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
