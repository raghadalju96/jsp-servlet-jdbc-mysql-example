package javapure.registration.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.catalina.servlet4preview.RequestDispatcher;

import javax.servlet.RequestDispatcher;

import javax.servlet.annotation.WebServlet;


import javapure.registration.dao.EmployeeDao;
import javapure.registration.model.Employee;

@WebServlet("/register")
public class EmployeeServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	private EmployeeDao employeeDao = new EmployeeDao();

	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/employeeregister.jsp");
		dispatcher.forward(request, response);
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fristName = request.getParameter("firstName");
		 String lastName = request.getParameter("lastName");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String address = request.getParameter("address");
	        String contact = request.getParameter("contact");
	        
	        
	        
	        Employee employee = new Employee();
	        
	        employee.setFirstName(fristName);
	        employee.setLastName(lastName);
	        employee.setUsername(username);
	        employee.setPassword(password);
	        employee.setContact(contact);
	        employee.setAddress(address);
	        
	        try {
	        	employeeDao.registerEmployee(employee);
	        	
	        }
	        catch(Exception e) {
	        	
	        	e.printStackTrace();
	        }
	    //    response.sendRedirect("employeedetails.jsp");
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/employeedetails.jsp");
			dispatcher.forward(request, response);

	}
}
