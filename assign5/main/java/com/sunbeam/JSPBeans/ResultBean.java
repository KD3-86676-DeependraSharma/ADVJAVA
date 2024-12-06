package com.sunbeam.JSPBeans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class ResultBean {
	private List<Candidate> candiList;
	
	public void ResultBean() {
		candiList=new ArrayList<Candidate>();
	}

	
	public List<Candidate> getCandiList() {
		return candiList;
	}


	public void setCandiList(List<Candidate> candiList) {
		this.candiList = candiList;
	}


	public void fetchCandidates() {
		try(CandidateDao candDao=new CandidateDaoImpl()){
			this.candiList=candDao.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
