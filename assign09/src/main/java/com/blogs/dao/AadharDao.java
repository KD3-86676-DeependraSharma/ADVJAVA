package com.blogs.dao;

import com.blogs.pojos.AadharCard;
import com.blogs.pojos.Address;

public interface AadharDao {
	String assignUserAadhar(Long userId,AadharCard newAdr);
}
