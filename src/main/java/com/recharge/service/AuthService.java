package com.recharge.service;

import com.recharge.dao.UserDAO;
import com.recharge.model.User;
import com.recharge.util.PasswordUtil;

public class AuthService {
	
	private final UserDAO userDAO = new UserDAO();
	
	public User login(String email, String password) {
		User user = userDAO.findByEmail(email);
		
		if(user == null) {
			throw new IllegalArgumentException("User not found");
		}
		
		String hashedInput = PasswordUtil.hashPassword(password);
		
		if(!hashedInput.equals(user.getPasswordHash())) {
			throw new IllegalArgumentException("Invalid email or password");
		}
		
		if(!"ACTIVE".equalsIgnoreCase(user.getStatus())) {
			throw new IllegalArgumentException("User account is inactive");
		}
		
		return user;
	}
}
