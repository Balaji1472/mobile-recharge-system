package com.recharge.menu;



import com.recharge.model.User;
import com.recharge.util.InputUtil;

public class UserMenu {

	private final User user;
	
	public UserMenu(User user) {
		this.user = user;
	}
	
	public void start() {
		boolean running = true;
		
		while(running) {
			System.out.println("\n=== USER DASHBOARD ===");
            System.out.println("Welcome, " + user.getFullName());
            System.out.println("1. Browse Plans");
            System.out.println("2. Recharge");
            System.out.println("3. View History");
            System.out.println("4. Logout");
            
            int choice = InputUtil.readInt("Choose option:", 1, 3);

            
            switch(choice) {
            	case 1:
            		System.out.println("Browse Plans");
            		break;
            	case 2:
            		System.out.println("Perform Recharge");
            		break;
            	case 3:
            		System.out.println("View History");
            		break;
            	case 4:
            		running = false;
            		System.out.println("User logged out");
            		break;
            	default:
            		System.out.println("Invalid choice");
            }
		}
	}
}
