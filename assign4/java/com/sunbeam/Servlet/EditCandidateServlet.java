package com.sunbeam.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;
//========================================================================================================================================
@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId=req.getParameter("id");
		int id=Integer.parseInt(candId);
		
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Edit Candidate</h2>");
		try(CandidateDao candDao=new CandidateDaoImpl()){
			Candidate c=candDao.findById(id);
			
			if(c != null) {
				out.println("<form method='post' action='editcand'>");
//				out.printf("Id: <input type='text' name='id' value='%d' readonly><br/>\n", c.getId());
				out.printf("Id: <input type='hidden' name='id' value='%d' readonly><br/>\n", c.getId());
				out.printf("Name: <input type='text' name='name' value='%s'><br/>\n", c.getName());
				out.printf("Party: <input type='text' name='party' value='%s'><br/>\n", c.getParty());
				out.printf("Votes: <input type='text' name='votes' value='%d' readonly><br/><br/>\n", c.getVotes());
				out.println("<input type='submit' value='Update Candidate'>");
				out.println("</form>");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("</body>");
		out.println("</html>");
	}
//	====================================================================================================================================
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String party=req.getParameter("party");
		int vote = Integer.parseInt(req.getParameter("votes"));
		
		Candidate c= new Candidate(id,name,party,vote);
		try(CandidateDao candDao = new CandidateDaoImpl()){
			
			int count = candDao.update(c);
			
			String message ="Candidate uopdated :"+count;
			req.setAttribute("msg", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		// forward req to result page
//		RequestDispatcher rd = req.getRequestDispatcher("result");
//		rd.forward(req, resp);
		
		// forward req to result page
		//RequestDispatcher rd = req.getRequestDispatcher("result");
		ServletContext ctx = this.getServletContext();
		RequestDispatcher rd = ctx.getRequestDispatcher("/result");
		rd.forward(req, resp);
		/*
		RequestDispatcher can be created using request as well as servlet context.
		If it is created using req, it can be used to forward req to any page w.r.t. current req.
		If it is created using servlet context, it can be used to forward req to any page in whole appln. 
		*/
	}
	

}
