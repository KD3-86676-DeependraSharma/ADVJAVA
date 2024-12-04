package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet  extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Home</title>");
		out.println("</head>");
		out.println("<body bgcolor='pink'>");
		out.println("<div>");
		out.println("<h1>First Name: deependra</h1>");
		out.println("<h1>Last Name: Sharma</h1>");
		out.println("<h2>Qualification: Pg-DAC</h2>");
		out.println("<h3>college/university: Sunbeam</h3>");
		out.println("<h3>birth date: 07/07/1235</h3>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
