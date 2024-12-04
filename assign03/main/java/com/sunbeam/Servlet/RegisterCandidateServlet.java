package com.sunbeam.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/Cregister")
public class RegisterCandidateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String party=req.getParameter("party");
		
		try(CandidateDao candDao=new CandidateDaoImpl()){
			
			Candidate c=new Candidate(0,name,party,0);
			int count=candDao.save(c);
			
			if(count==1) {
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Registration</title>");
				out.println("</head>");
//				========================================================================4
				//get app title from ctx param and display it
				
				ServletContext app=this.getServletContext();
				String appTitle=app.getInitParameter("app.title");
				out.printf("<h1>%s</h1>",appTitle);
				
				String color=app.getInitParameter("color");
				out.printf("<body bgcolor='%s'>",color);
//				=========================================================================
//				cookie=========================================
				Cookie[] arr=req.getCookies();
				String userName = "",role = "";
				if(arr !=null) {
					for(Cookie c1:arr) {
						if(c.getName().equals("uname")) {
							userName = c1.getValue();
						}
						if(c.getName().equals("role")) {
							role=c1.getValue();
						}
					}
				}
				out.printf("Hello,%s (%s)<hr/>\n",userName,role);
//				=================================================
				out.println("<h1>Candidate Registration successful...</h1>");
				out.println("<a href='result'>Login page</a>");
				out.println("</body>");
				out.println("</html>");
			}
			else {
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Registration</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Candidate Registration Failed...</h1>");
				out.println("<a href='result'>Login page</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
