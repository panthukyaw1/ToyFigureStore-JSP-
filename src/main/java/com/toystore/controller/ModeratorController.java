package com.toystore.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Moderator;
import com.hostmdy.model.ModeratorDAO;
import com.hostmdy.model.ToyFigure;
import com.hostmdy.model.ToyFigureDAO;

/**
 * Servlet implementation class ModeratorController
 */
public class ModeratorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name = "jdbc/hotToyFigureStore")
	private DataSource dataSource;
	
	private ModeratorDAO moderatorDAO;
	private ToyFigureDAO toyFigureDAO;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		moderatorDAO = new ModeratorDAO(dataSource);
		toyFigureDAO = new ToyFigureDAO(dataSource);
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModeratorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String mode = request.getParameter("mode");
		
		if (mode == null) {
			mode = "SIGNIN";
		}
		
		switch (mode) {
		case "SIGNIN": 
			signin(request, response);
			break;
		case "SIGNUP":
			signup(request, response);
			break;
		case "ADMIN":
			showToyFigureList(request, response);
			break;
	
		}
	}
	
	private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Moderator moderator = new Moderator(email, password);
		int rowEffected = this.moderatorDAO.createAdmin(moderator);
		
		if(rowEffected > 0 )
			response.sendRedirect("signin-form.html");
	}
	private void signin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(moderatorDAO.isValid(email, password))
			showToyFigureList(request, response);
		else
			response.sendRedirect("signin-form.html");
	}
	   private void showToyFigureList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	    	List<ToyFigure> toyFigureList = this.toyFigureDAO.getToyFigureList();
	    	request.setAttribute("toyFigureList",toyFigureList);
	    	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	    	rd.forward(request, response);
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
