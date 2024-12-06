package com.sunbeam.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//get email and password from login page
		String email = req.getParameter("email");
		String password=req.getParameter("passwd");
		
		//validate login aginst db record 
		try(UserDao userdao = new UserDaoImpl()){
			User dbuser =userdao.findByEmail(email);
			if(dbuser!=null&& dbuser.getPassword().equals(password)) {
//				cookies ===================================== 
				Cookie c1 = new Cookie("uname",dbuser.getFirstName());
				c1.setMaxAge(3600);
				resp.addCookie(c1);
				
				//store logged in user into session
				HttpSession session = req.getSession();
				session.setAttribute("curUser", dbuser);
				
				
				Cookie c2=new Cookie("role",dbuser.getRole());
				c2.setMaxAge(3600);
				resp.addCookie(c2);
//				=====================================
				if(dbuser.getRole().equals("admin")) {
					resp.sendRedirect("result"); // go to ResultServlet
				} else { // if(dbUser.getRole().equals("voter"))
					;resp.sendRedirect("candlist"); // go to CandidateListServlet
				}
			}
			
			//if login is failed show invalid user
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login</title>");
//				========================================================================4
				//get app title from ctx param and display it
				ServletContext app=this.getServletContext();
				
				String appTitle=app.getInitParameter("app.title");
				out.printf("<h1>%s</h1>",appTitle);
				
				String color=app.getInitParameter("color");
				out.printf("<body bgcolor='%s'>",color);
//				=========================================================================
						

				out.println("<h1>Login Failed</h1>");
				out.println("<p>Sorry ! invalid login and Password</p>");
				out.println("<p><a href='index.html'>Login again</a></p>");
				out.println("</body>");
				out.println("</head>");
				out.println("</html>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

		//if login is successful go to condidate list servlate
	}

}
