package com.cdac.dao;

import com.cdac.dto.User;

public interface UserDao {
	void insertUser(User user);
	boolean checkUser(User user);
	boolean verify_mail(User user);
	void resetpass(User user);
	boolean checkEmail(User user);
	
	
}
