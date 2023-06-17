package com.flyaway.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.descriptor.DateTimeUtils;

import com.flyaway.entities.Flight;
import com.flyaway.entities.UserEntity;
import com.flyaway.util.HibernateUtil;


/**
 * Servlet implementation class FlightSearch
 */
public class FlightSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
		out.println("<html><body>");
		String page=" ";
		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");
		String fromDate = request.getParameter("departure_dt");
		String str_noOfPax=request.getParameter("no_of_pax");
		int noOfPax=Integer.parseInt(str_noOfPax);
			
		//verify origin and destination are not same
		if(origin.equals(destination)){
			page="org_dest_error.jsp";
			RequestDispatcher dd=request.getRequestDispatcher(page);
			dd.forward(request, response);
		}
		
		//verify date of journey
		  /* DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm/dd/yyyy");  
		   LocalDateTime now = LocalDateTime.now();
		   String today = dtf.format(now);*/
		   
		   LocalDate travelDate = LocalDate.parse(fromDate);
		   LocalDate today = LocalDate.now();
		   if(travelDate.compareTo(today)<0)
		   {
			   page="travelDate_error.jsp";
				RequestDispatcher dd=request.getRequestDispatcher(page);
				dd.forward(request, response);
		   }
		   
		SessionFactory factory = HibernateUtil.getSessionFactory();

		// Open a connection to the databse
		Session session = factory.openSession();
		
		try {
			List<Flight> fs = (List<Flight>) session
					.createQuery("FROM Flight WHERE origin='" + origin
							+ "' AND destination='" + destination + "'")
					.list();			
				
			session.setProperty("no_of_pax", noOfPax);
			session.setProperty("fromDate", fromDate);	
			
			 request.setAttribute("no_of_pax", noOfPax);
			 request.setAttribute("fromDate", fromDate);
	         request.setAttribute("results", fs);
	         request.getRequestDispatcher("searchresults.jsp").forward(request, response);
	         
	        // out.println("</table>");
		}catch(Exception e) {
			System.out.println(e);
		}
			
			
			
	}

	
}
