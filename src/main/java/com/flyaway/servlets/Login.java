package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.flyaway.entities.UserEntity;
import com.flyaway.util.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	
	
	  protected void doGet(HttpServletRequest
	  request, HttpServletResponse response) throws
	  ServletException, IOException {
	  response.sendRedirect("index.jsp"); }
	 
	 

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		String page = " ";
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		// Open a connection to the databse
		Session session = factory.openSession();
		session.setProperty("username", username);

		//Fetching user details from db
		try {
		UserEntity user = (UserEntity) session
					.createQuery("FROM UserEntity WHERE username='" + username
							+ "' AND password='" + password + "'")
					.uniqueResult();
		
		
		//validating details
			if (user.getUsername().equals(username)&&user.getPassword().equals(password)) {
				page="homepage.jsp";
				RequestDispatcher rd=request.getRequestDispatcher(page);
				request.getSession().setAttribute("username", username);
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			page="error.jsp";
			RequestDispatcher dd=request.getRequestDispatcher(page);
			dd.forward(request, response);
			out.println("Check your credentials");
		}

		session.close();

		out.println("</body></html>");

	}

}
