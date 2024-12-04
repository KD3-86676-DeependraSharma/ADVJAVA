package com.sunbeam.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

@WebServlet("/delcand")
public class DeleteCandidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessRequest(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessRequest(req,resp);
	}
	
	protected void ProcessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId =req.getParameter("id");
		int id =Integer.parseInt(candId);
		
		try(CandidateDao candDao=new CandidateDaoImpl()){
			int count= candDao.deleteById(id);
			String message="Candidate Deleted :"+count;
			req.setAttribute("msg", message);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		go back to result servlet
		RequestDispatcher rd=req.getRequestDispatcher("result");
		rd.forward(req, resp);
		
	}
}
