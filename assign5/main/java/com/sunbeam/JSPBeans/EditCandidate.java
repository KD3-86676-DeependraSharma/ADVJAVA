package com.sunbeam.JSPBeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class EditCandidate {
private int candId;
private Candidate cand;

public Candidate getCand() {
	return cand;
}

public void setCand(Candidate cand) {
	this.cand = cand;
}

public int getCandId() {
	return candId;
}

public void setCandId(int candId) {
	this.candId = candId;
}

public void editCandidate() {
	try(CandidateDao candDao=new CandidateDaoImpl()){
		this.cand=candDao.findById(candId);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
