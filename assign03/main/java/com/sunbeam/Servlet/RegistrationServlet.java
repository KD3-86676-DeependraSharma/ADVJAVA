package com.sunbeam.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String first_name =req.getParameter("firstName");
		String last_name =req.getParameter("lastName");
		String email =req.getParameter("email");
		String password =req.getParameter("password");
		String dob =req.getParameter("dob");
		Date bd=Date.valueOf(dob);
		
		try(UserDao userdao=new UserDaoImpl()){
			User u=new User(0,first_name,last_name,email,password,bd,0,"voter");
			int count =userdao.save(u);
			if(count==1) {
				
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Registration</title>");
				out.println("</head>");
				out.println("<body>");
//				cookie=========================================
				Cookie[] arr=req.getCookies();
				String userName = "",role = "";
				if(arr !=null) {
					for(Cookie c:arr) {
						if(c.getName().equals("uname")) {
							userName = c.getValue();
						}
						if(c.getName().equals("role")) {
							role=c.getValue();
						}
					}
				}
				out.printf("Hello,%s (%s)<hr/>\n",userName,role);
//				=================================================
				out.println("<h1>Registration successful...</h1>");
				out.println("<a href='index.html'>Login page</a>");
//				========================================================================4
				//get app title from ctx param and display it
				
				ServletContext app=this.getServletContext();
				String appTitle=app.getInitParameter("app.title");
				out.printf("<h1>%s</h1>",appTitle);
				
				String color=app.getInitParameter("color");
				out.printf("<body bgcolor='%s'>",color);
//				=========================================================================
				out.println("</html>");	
			}
			else {
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Registration</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Registration Failed...</h1>");
				out.println("<a href='index.html'>Login page</a>");
				out.println("</body>");
				out.println("</html>");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
	
	

}
