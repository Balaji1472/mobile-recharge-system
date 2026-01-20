package com.recharge.model;

import java.time.LocalDateTime;

public class User {

	private int userId;
	private String fullName;
	private String gender;
	private String email;
	private String passwordHash;
	private Role role;
	private String status;
	private LocalDateTime createdAt;
	
	public User() {
		
	}
	
	public User(int userId, String fullName, String gender, String email, String passwordHash,
			Role role, String status, LocalDateTime createdAt) {
		this.userId = userId;
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.passwordHash = passwordHash;
		this.role = role;
		this.status = status;
		this.createdAt = createdAt;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public Role getRole() {
		return role;
	}
	
	public String getStatus() {
		return status;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}


