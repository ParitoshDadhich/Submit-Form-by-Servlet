package com.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet	 {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");
		 PrintWriter writer = resp.getWriter();
		 writer.println("<h1>Welcome to Servlet Registeration Page!</h1>");
		 
		 String name = req.getParameter("user_name");
		 String password = req.getParameter("user_password");
		 String email = req.getParameter("user_email");
		 String gender = req.getParameter("user_gender");
		 String course = req.getParameter("user_course");
		 
		 String cond = req.getParameter("condition");
		 
		 if(cond != null && cond.equals("checked")) {
			 writer.println("<h2> Name : " + name + "<h2>");
			 writer.println("<h2> Password : " + password + "<h2>");
			 writer.println("<h2> Email : " + email + "<h2>");
			 writer.println("<h2> Gender : " + gender + "<h2>");
			 writer.println("<h2> Courses : " + course + "<h2>");
			 
			 
			 
			 
			 /*
			  * Assuming I have saved the above data to db;
			  * calling success servlet from current survlet. 
			  * Here I am sending the response of current Servlet to success Servlet;
			  */
			 
			 RequestDispatcher rd = req.getRequestDispatcher("success");
			 rd.forward(req, resp);
			 
		 } else {
			 writer.println("<h2>You have not accepted terms and condtions!</h2>");
			 
			 // including output of index.html (home page)
			 // Here RequestDispacter will be including the response of index.html with RequestServlet
			 
			 // getting object of requestDisptacher
			 RequestDispatcher rd = req.getRequestDispatcher("index.html");
			 
			 // applying including logic
			 rd.include(req, resp);
		 }
	}
}
