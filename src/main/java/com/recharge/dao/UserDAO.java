package com.recharge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.recharge.config.DBConnection;
import com.recharge.model.Role;
import com.recharge.model.User;

public class UserDAO {
	
	private static final String FIND_BY_EMAIL = 
			"select u.user_id, u.full_name, u.gender, u.email, u.password_hash, " +
			"u.status, u.created_at, r.role_name " +
			"from users u join role r on u.role_id = r.role_id " +
			"where u.email = ?";
	
	public User findByEmail(String email) {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(FIND_BY_EMAIL);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next()) {
				return null;
			}
			
			return new User(
                    rs.getInt("user_id"),
                    rs.getString("full_name"),
                    rs.getString("gender"),
                    rs.getString("email"),
                    rs.getString("password_hash"),
                    Role.valueOf(rs.getString("role_name").toUpperCase()),
                    rs.getString("status"),
                    rs.getTimestamp("created_at").toLocalDateTime()
            );
			
		}
		catch(Exception e) {
			throw new RuntimeException("Failed to fetch user by email", e);
		}
	}
}
