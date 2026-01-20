package com.recharge.menu;


import com.recharge.util.InputUtil;

public class GuestMenu {

    public void start() {

        boolean running = true;

        while (running) {
            System.out.println("\n=== GUEST MENU ===");
            System.out.println("1. Browse Plans");
            System.out.println("2. Register");
            System.out.println("3. Back to Main Menu");

            int choice = InputUtil.readInt("Choose option:", 1, 3);

            switch (choice) {
                case 1:
                    System.out.println("Browse Plans");
                    break;
                case 2:
                    System.out.println("Register");
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
