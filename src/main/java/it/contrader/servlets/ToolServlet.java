package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ToolDTO;
import it.contrader.service.Service;
import it.contrader.service.ToolService;

public class ToolServlet extends HttpServlet {
	
	// Variabili e costruttori
	private static final long serialVersionUID = 1L;
	public ToolServlet() {
	}

	// Aggiornamento della lista
	public void updateList(HttpServletRequest request) {
		Service<ToolDTO> service = new ToolService();
		List<ToolDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	// Smistamento delle richieste
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ToolDTO> service = new ToolService();
		String mode = request.getParameter("mode");
		ToolDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "TOOLLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/tool/toolmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/tool/readtool.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/tool/updatetool.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name         = request.getParameter("name").toString();
			String description  = request.getParameter("description").toString();
			dto = new ToolDTO (name, description);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/tool/toolmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name        = request.getParameter("name");
			description = request.getParameter("description");
			id  = Integer.parseInt(request.getParameter("id"));
			dto = new ToolDTO (id, name, description);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/tool/toolmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/tool/toolmanager.jsp").forward(request, response);
			break;
		}
	}
}
