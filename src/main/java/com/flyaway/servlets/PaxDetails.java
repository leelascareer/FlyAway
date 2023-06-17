package com.flyaway.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.flyaway.util.HibernateUtil;
import com.flyaway.util.PaxUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaxDetails
 */
public class PaxDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest
	 *      request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page=" ";
			
			
		  String[] firstname = request.getParameterValues("firstname");
		  String[] lastname = request.getParameterValues("lastname");
		  String[] age = request.getParameterValues("age");
		  String[] govId = request.getParameterValues("govId");
		  String[] ph=request.getParameterValues("phone");
		  boolean updated = false;
		  
		  int length = firstname.length;
		  
		  int[] int_age = new int[length];
		  for (int i=0; i<length;i++) {
			  int_age[i]=Integer.parseInt(age[i]);
		  }
		  
			/*
			 * int[] int_ph = new int[length]; for (int i=0;
			 * i<length;i++) {
			 * int_ph[i]=Integer.parseInt(ph[i]); }
			 */
		  
		  
		  List<PaxUtil> pax = new ArrayList<PaxUtil>();

			for (int i = 0; i < length; i++) {
				PaxUtil p = new PaxUtil();
				p.setFirstname(firstname[i]);
				p.setLastname(lastname[i]);
				p.setAge(int_age[i]);
				p.setGovId(govId[i]);
				p.setPh(ph[i]);
				pax.add(p);

				// Generate PNR
				Random r = new Random();
				int pnr = r.nextInt();
				p.setPNR(pnr);
				}
		  
			
		  SessionFactory factory =  HibernateUtil.getSessionFactory();
		  
		  // Open a connection to the databse 
		  Session session = factory.openSession();
		  
			
		  			
		  //adding passenger details and pnr to db 
		  for(PaxUtil p: pax) {	  
		  try {
			  org.hibernate.Transaction txn = session.beginTransaction();
			  int record = session.createQuery("insert into Passenger(pnr,firstname,lastname,age,govId,ph) values "
			  		+ "("+p.getPNR()+", '"+p.getFirstname()+"','"+p.getLastname()
		  														+"',"+p.getAge()+", '"+p.getGovId()+"', '"
		  														+p.getPh()+"')").executeUpdate();
			  txn.commit();
		  System.out.println("Updated"+record+"record(s)");
		  updated=true;
		  } catch (Exception e) { e.printStackTrace();
		  updated=false;
		  }
		  }
		  
		  //To display PNR Details
		  if (updated) {
			  request.setAttribute("travelDetails", pax);
			   page="confirmation.jsp";
				RequestDispatcher dd=request.getRequestDispatcher(page);
				dd.forward(request, response);
		  } else {
			  page="paxupdatefailed.jsp";
				RequestDispatcher dd=request.getRequestDispatcher(page);
			  response.sendRedirect(page);
		  }
		  session.close();
		 

	}

}
