package com.sunbeam.daos;
import com.sunbeam.entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.utils.*;

public class CandidateDaoImpl extends Dao implements CandidateDao {
	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindById;
	private PreparedStatement stmtsave;
	private PreparedStatement stmtupdate;
	private PreparedStatement stmtDeleteByID;
	
	private PreparedStatement stmtfindByMaxVotes;
	private PreparedStatement stmtIncrVote;
	
	
	public CandidateDaoImpl() throws Exception{
		String sqlFindAll="select * from candidates";
		stmtFindAll=con.prepareStatement(sqlFindAll);
		
		String sqlFindById="select * from candidates where id=?";
		stmtFindById=con.prepareStatement(sqlFindById);
		
		String sqlsave="INSERT INTO candidates(name, party, votes) VALUES(?, ?, ?)";
		stmtsave=con.prepareStatement(sqlsave);
		
		String sqlupdate="update candidates set name=?,party=?,votes=? where id=?";
		stmtupdate=con.prepareStatement(sqlupdate);
		
		String sqlDelete="delete from candidates where id=?";
		stmtDeleteByID=con.prepareStatement(sqlDelete);
		
		/*=============================================================================*/
		String sqlfindByMaxVotes="SELECT * FROM candidates ORDER BY votes DESC LIMIT 1";
		stmtfindByMaxVotes=con.prepareStatement(sqlfindByMaxVotes);
		
		String sqlIncrVote = "UPDATE candidates SET votes = votes + 1 WHERE id = ?";
		stmtIncrVote = con.prepareStatement(sqlIncrVote);
		
	}

	public void close() throws Exception {
		stmtIncrVote.close();
		stmtFindById.close();
		stmtFindAll.close();
		super.close();
	}
	@Override
	public List<Candidate> findAll() throws Exception{
		// TODO Auto-generated method stub
		List<Candidate>list=new ArrayList<Candidate>();
		
		try(ResultSet rs=stmtFindAll.executeQuery()){
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String party=rs.getString("party");
				int votes=rs.getInt("votes");
				
				Candidate c=new Candidate(id,name,party,votes);
				list.add(c);
			}
		}//rs.close
		return list;
	}

	@Override
	public Candidate findById(int id) throws Exception {
		stmtFindById.setInt(1, id);
		try(ResultSet rs = stmtFindById.executeQuery()){
			if(rs.next()) {
				id=rs.getInt("id");
				String name= rs.getString("name");
				String party=rs.getString("party");
			   int votes=rs.getInt("votes");
			   Candidate c= new Candidate(id,name,party,votes);
			   return c;
			   
			}
		}//rs.close
		return null;
	}

	@Override
	public int save(Candidate c) throws Exception {
		// TODO Auto-generated method stub
		stmtsave.setString(1,c.getName());
		stmtsave.setString(2,c.getParty());
		stmtsave.setInt(3,c.getVotes());
		
		int count=stmtsave.executeUpdate();
		return count;
	}

	@Override
	public int update(Candidate c) throws Exception {
		stmtupdate.setString(1, c.getName());
		stmtupdate.setString(2, c.getParty());
		stmtupdate.setInt(3, c.getVotes());
		stmtupdate.setInt(4, c.getId());
		int count = stmtupdate.executeUpdate();
		return count;
	}
	
	@Override
	public int deleteById(int id) throws Exception {
		stmtDeleteByID.setInt(1, id);
		int count = stmtDeleteByID.executeUpdate();
		return count;
	}

	@Override
	public Candidate findByMaxVotes() throws Exception {
		// TODO Auto-generated method stub
		try(ResultSet rs = stmtfindByMaxVotes.executeQuery()){
			if(rs.next()) {
				int id=rs.getInt("id");
				String name= rs.getString("name");
				String party=rs.getString("party");
			   int votes=rs.getInt("votes");
			   Candidate c= new Candidate(id,name,party,votes);
			   return c;   
			}
		return null;
		}
	}

//	@Override
//	public int incrVoteById(int id) throws Exception {
//		// TODO Auto-generated method stub
//		stmtincrVoteById.setInt(1, id);
//		try(ResultSet rs = stmtfindByMaxVotes.executeQuery()){
//			if(rs.next()) {
//				int c = stmtupdate.executeUpdate();
//				return c;
//			}
//		}
//		return 0;
//	}

	@Override
	public int incrVote(int candId) throws Exception {
		stmtIncrVote.setInt(1, candId);
		int count = stmtIncrVote.executeUpdate();
		return count;
	}
}