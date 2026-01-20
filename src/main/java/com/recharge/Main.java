package com.recharge;

import com.recharge.config.DBConnection;
import com.recharge.menu.AdminMenu;
import com.recharge.menu.GuestMenu;
import com.recharge.menu.UserMenu;
import com.recharge.model.User;
import com.recharge.service.AuthService;
import com.recharge.util.InputUtil;
import com.recharge.util.ValidationUtil;

    
public class Main {
    public static void main(String[] args) {
    	
    	DBConnection.initialize();
    	AuthService authService = new AuthService();
    	
    	boolean running = true;
    	
    	try {
    		while(running) {
    			
    			System.out.println("\n==== MOBILE RECHARGE SYSTEM ====");
    			System.out.println("1. Admin Login");
    			System.out.println("2. User Login");
    			System.out.println("3. Guest Login");
    			System.out.println("4. Exit");
    			
   
    			int choice = InputUtil.readInt("Choose option:", 1, 4);
    			
    			switch(choice) {
    				case 1:
    					String email;
                        do {
                            email = InputUtil.readString("Email:");
                            if (!ValidationUtil.isValidEmail(email)) {
                                System.out.println("Invalid email format.");
                            }
                        } while (!ValidationUtil.isValidEmail(email));

                        String password = InputUtil.readString("Password:");
    					
    					try {
    						User user = authService.login(email, password);
    						
    						switch(user.getRole()) {
    							case ADMIN:
    								new AdminMenu(user).start();
    								break;
    							default:
    								System.out.println("Invalid role");
    						}
    					}
    					catch(Exception e) {
    						System.out.println(e.getMessage());
    					}
    					break;
    					
    				case 2:
    					String uEmail;
                        do {
                            uEmail = InputUtil.readString("Email:");
                            if (!ValidationUtil.isValidEmail(uEmail)) {
                                System.out.println("Invalid email format.");
                            }
                        } while (!ValidationUtil.isValidEmail(uEmail));

                        String uPassword = InputUtil.readString("Password:");
    					
    					try {
    						User user = authService.login(uEmail, uPassword);
    						
    						switch(user.getRole()) {
    							case USER:
    								new UserMenu(user).start();
    								break;
    							default:
    								System.out.println("Invalid role");
    						}
    					}
    					catch(Exception e) {
    						System.out.println(e.getMessage());
    					}
    					break;
                        
                    case 3:
                        new GuestMenu().start();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Exiting application...");
                        break;
                    default:
                        System.out.println("Invalid choice");
    			}
    		}
    	}
    	finally {
    		DBConnection.close();
    	}
    }
}
