package com.recharge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.recharge.config.DBConnection;
import com.recharge.model.RechargeTransaction;

public class RechargeTransactionDAO {
	
	private static final String INSERT_TX = 
			"insert into recharge_transaction "+
			"(user_id, connection_id, plan_id, final_amount, status, initiated_at) "+
			"values (?, ?, ?, ?, ?, now())";
	
	private static final String UPDATE_STATUS = 
			"update recharge_transaction "+
			"set status = ?, completed_at = case when ? <> 'PAYMENT_IN_PROGRESS' then now() else null end " +
			"where recharge_id = ?";
	
	public int createInitiatedTransaction(RechargeTransaction tx) {
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT_TX, Statement.RETURN_GENERATED_KEYS);
					
			ps.setInt(1, tx.getUserId());
			ps.setInt(2, tx.getConnectionId());
			ps.setInt(3, tx.getPlanId());
			ps.setDouble(4, tx.getFinalAmount());
			ps.setString(5, "INITIATED");
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			throw new RuntimeException("Failed to create recharge transaction");
			
		}
		catch(Exception e) {
			throw new RuntimeException("Error creating recharge transaction", e);
		}
	}
		
	public void updateStatus(int rechargeId, String status) {
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE_STATUS);
			
			ps.setString(1,  status);
			ps.setString(2, status);
			ps.setInt(3,  rechargeId);
			
			ps.executeUpdate();
		}
		catch(Exception e) {
			throw new RuntimeException("Error updating recharge status", e);
		}
		
	}
}
