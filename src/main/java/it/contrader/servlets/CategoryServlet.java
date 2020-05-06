package it.contrader.servlets;

import java.util.List;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.ToolDTO;
import it.contrader.service.Service;
import it.contrader.service.CategoryService;
import it.contrader.service.ToolService;

public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CategoryServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<CategoryDTO> service = new CategoryService();
		List<CategoryDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
		getTool(request);
	}
	
	public void getTool(HttpServletRequest request ) {
		Service<ToolDTO> serviceTool = new ToolService();
		List<ToolDTO>listDTO = serviceTool.getAll();
		request.setAttribute("list_T", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CategoryDTO> service = new CategoryService();
		Service<ToolDTO> toolservice = new ToolService();
		String mode = request.getParameter("mode");
		CategoryDTO dto;
		ToolDTO tooldto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "CATEGORYLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			int toolid = dto.getIdtool();
			tooldto = toolservice.read(toolid); 
			request.setAttribute("dto", dto);
			request.setAttribute("tooldto", tooldto);
			getTool(request);
			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/category/readcategory.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/category/updatecategory.jsp").forward(request, response);
			
			break;
			
		case "INSERT":
			String name = request.getParameter("name").toString();
			String description = request.getParameter("description").toString();
			int idtool = Integer.parseInt(request.getParameter("idtool").toString());
			dto = new CategoryDTO (name,description,idtool);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			description = request.getParameter("description");
			idtool = Integer.parseInt(request.getParameter("idtool"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new CategoryDTO (id,name,description,idtool);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
			break;
		}
	}
}
