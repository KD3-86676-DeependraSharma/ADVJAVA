package com.sunbeam.JSPBeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean {
	private int candId;
	int count;
	
	public DeleteCandidateBean() {
		
	}

	public DeleteCandidateBean(int candId) {
		super();
		this.candId = candId;
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void deleteCandidate() {
		try(CandidateDao candDao=new CandidateDaoImpl()){
			count=candDao.deleteById(candId);
			String message = "Candidates Deleted: " + count;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}

