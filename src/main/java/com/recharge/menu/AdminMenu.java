package com.recharge.menu;


import com.recharge.model.User;
import com.recharge.util.InputUtil;



public class AdminMenu {
	
	private final User admin;
	
	public AdminMenu(User admin) {
		this.admin = admin;
	}
	
	public void start() {
		boolean running = true;
		
		while(running) {
			System.out.println("\n=== ADMIN DASHBOARD ===");
            System.out.println("Welcome, " + admin.getFullName());
            System.out.println("1. View Plans");
            System.out.println("2. Manage Plans");
            System.out.println("3. Logout");
            
            int choice = InputUtil.readInt("Choose option:", 1, 3);
            
            switch(choice) {
            	case 1:
            		System.out.println("View Plans");
            		break;
            	case 2:
            		System.out.println("Manage Plans");
            		break;
            	case 3:
            		running = false;
            		System.out.println("Admin logged out");
            		break;
            	default:
            		System.out.println("Invalid choice");
            }
		}
	}
}
