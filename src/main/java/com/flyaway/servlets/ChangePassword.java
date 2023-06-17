package com.flyaway.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.flyaway.entities.UserEntity;
import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			
			String page = " ";
			String username= (String)request.getSession().getAttribute("username");
			String oldpassword = request.getParameter("oldpassword");
			String newpassword = request.getParameter("newpassword");
			String c_newpassword = request.getParameter("c_newpassword");
			
			//verify origin and destination are not same
			if(!(newpassword).equals(c_newpassword)){
				page="changepassworderror.jsp";
				RequestDispatcher dd=request.getRequestDispatcher(page);
				dd.forward(request, response);
			}

			SessionFactory factory = HibernateUtil.getSessionFactory();

			// Open a connection to the databse
			Session session = factory.openSession();


			//Fetching user details from db
			try {
				org.hibernate.Transaction txn = session.beginTransaction();
				
				  int userid = (int) session
				  .createQuery("SELECT userid  FROM UserEntity WHERE username = '"+username+"'").uniqueResult();	
				  int i = session
						.createQuery("UPDATE UserEntity SET password = '"+newpassword+"'"
								+"Where userid="+userid).executeUpdate();
					txn.commit();
					if(i==1) {
					page="logout.jsp";
					RequestDispatcher rd=request.getRequestDispatcher(page);
					request.getSession().setAttribute("username", username);
					rd.forward(request, response);
					}
				} catch (Exception e) {
				e.printStackTrace();
				page="updateerror.jsp";
				RequestDispatcher dd=request.getRequestDispatcher(page);
				dd.forward(request, response);
				out.println("Check your credentials");
			}

			session.close();

			out.println("</body></html>");

		}
}
