package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.*;

public interface UserDao extends AutoCloseable{

	List<User>findAll() throws Exception;
	User findById(int id) throws Exception;
	User findByEmail(String email) throws Exception;
	int save(User u) throws Exception;
	
	int incrVoteById(int id) throws Exception;
	int update(User u) throws Exception;

}
