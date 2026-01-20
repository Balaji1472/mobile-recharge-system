package com.recharge.model;

import java.time.LocalDateTime;

public class RechargeTransaction {
	
	private int rechargeId;
	private int userId;
	private int connectionId;
	private int planId;
	private double finalAmount;
	private String status;
	private LocalDateTime initiatedAt;
	private LocalDateTime completedAt;
	
	 
	public RechargeTransaction() {
		
	}
	
	public RechargeTransaction(int userId, int connectionId, int planId, double finalAmount) {
		this.userId = userId;
		this.connectionId = connectionId;
		this.planId = planId;
		this.finalAmount = finalAmount;
		this.status = "INITIATED";
	}
	
	public int getRechargeId() {
		return rechargeId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getConnectionId() {
		return connectionId;
	}
	
	public int getPlanId() {
		return planId;
	}
	
	public double getFinalAmount() {
		return finalAmount;
	}
	
	public String getStatus() {
		return status;
	}
	
	public LocalDateTime getInitiatedAt() {
		return initiatedAt;
	}
	
	public LocalDateTime getCompletedAt() {
		return completedAt;
	}
}
