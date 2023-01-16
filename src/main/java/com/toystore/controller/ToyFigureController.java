package com.toystore.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.ToyFigure;
import com.hostmdy.model.ToyFigureDAO;

/**
 * Servlet implementation class ToyFigureController
 */
public class ToyFigureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/hotToyFigureStore")
	private DataSource dataSource;
	
	private ToyFigureDAO toyFigureDAO;
	
	
	@Override
	public void init() throws ServletException {
		toyFigureDAO = new ToyFigureDAO(dataSource);
	};
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToyFigureController() {
        super();
        // TODO Auto-generated constructor stub
    }
    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		
		if(mode == null) {
			mode = "LIST";
		}
		
		switch(mode) {
		case "LIST":
			showToyStoreList(request, response);
			break;
		case "CREATE":
			creatToyFigure(request, response);
			break;
		case "UPDATE":
			updateToyFigure(request, response);
			break;
		case "DELETE":
			deleteToyFigure(request, response);
			break;
		case "LOAD":
			LoadToyFigureById(request, response);
			break;
		case "ADMIN":
			showToyFigureList(request, response);
			break;
		case "BUY":
			buyToyFigure(request, response);
			break;
			default:
				showToyFigureList(request, response);
				break;
		}
	}
    private void showToyFigureList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	List<ToyFigure> toyFigureList = this.toyFigureDAO.getToyFigureList();
    	request.setAttribute("toyFigureList",toyFigureList);
    	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    	rd.forward(request, response);
    }
    private void showToyStoreList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	List<ToyFigure> toyFigureList = this.toyFigureDAO.getToyFigureList();
    	request.setAttribute("toyFigureList",toyFigureList);
    	RequestDispatcher rd = request.getRequestDispatcher("store.jsp");
    	rd.forward(request, response);
    }
    
    private void LoadToyFigureById(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	ToyFigure toyFigure = this.toyFigureDAO.getToyFigure(id);
    	request.setAttribute("toyfigure", toyFigure);
    	RequestDispatcher rd = request.getRequestDispatcher("updatefigure.jsp");
    	rd.forward(request, response);
    }

    private void creatToyFigure(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	String name = request.getParameter("name");
    	int spareParts = Integer.parseInt(request.getParameter("spareParts"));
    	boolean stand = Boolean.parseBoolean("stand");
    	int price = Integer.parseInt(request.getParameter("price"));
    	
    	ToyFigure toyFigure = new ToyFigure(name, spareParts, stand, price);
    	int rowEffected = this.toyFigureDAO.creatToyFigure(toyFigure);
    	
    	if(rowEffected > 0 ) {
    		showToyFigureList(request, response);
    	}

    }
    private void updateToyFigure(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	String name = request.getParameter("name");
    	int spareParts = Integer.parseInt(request.getParameter("spareParts"));
    	boolean stand = Boolean.parseBoolean("stand");
    	int price = Integer.parseInt(request.getParameter("price"));
    	
    	ToyFigure toyFigure = new ToyFigure(id, name, spareParts, stand, price);
    	int rowEffected = this.toyFigureDAO.updateToyFigure(toyFigure);
    	if(rowEffected > 0 ) {
    		showToyFigureList(request, response);
    	}
    }
    private void deleteToyFigure(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	int rowEffected = this.toyFigureDAO.deleteToyFigure(id);
    	if(rowEffected > 0 ) {
    		showToyFigureList(request, response);
    	}
    	
    }
    private void buyToyFigure(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	ToyFigure toyFigure = this.toyFigureDAO.getToyFigure(id);
    	request.setAttribute("toyfigure", toyFigure);
    	RequestDispatcher rd = request.getRequestDispatcher("buyfigure.jsp");
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
