package com.flyaway.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.flyaway.entities.Flight;
import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class FlightDetails
 */
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String flightno = request.getParameter("flightno");
		String noofpax = request.getParameter("no_of_pax");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		System.out.println("Selected flight number::"+flightno);
		
		  System.out.println("!!!!!"+flightno+"!!!!!!!!!!!"); 
		  int length = flightno.length();
		  flightno=flightno.substring(0,2)+" "+flightno. substring(2,length);
		  System.out.println(flightno);	
		
				
		SessionFactory factory = HibernateUtil.getSessionFactory();
		// Open a connection to the databse
				Session session = factory.openSession();
				
				try {
					Flight fs = (Flight) session
							.createQuery("FROM Flight WHERE flightno='" + flightno+"'")
							.uniqueResult();
					request.setAttribute("noofpax", noofpax);
					request.setAttribute("fromDate", fromDate);
					request.setAttribute("toDate", toDate);
					request.setAttribute("results", fs);
					request.getRequestDispatcher("flightdetails.jsp").forward(request, response);
	}catch(Exception e) {
		System.out.println(e);
	}
	}

}
