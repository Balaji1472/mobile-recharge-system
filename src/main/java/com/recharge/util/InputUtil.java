package com.recharge.util;

import java.util.Scanner;

public class InputUtil {
	
	private static final Scanner sc = new Scanner(System.in);
	
	private InputUtil() {
		
	}
	
	public static int readInt(String message) {
		while(true) {
			try {
				System.out.println(message+ " ");
				return Integer.parseInt(sc.nextLine().trim());
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid number. Please try again.");
			}
		}
	}
	
	public static int readInt(String message, int min, int max) {
		while(true) {
			int value = readInt(message);
			if(value >= min && value <= max) {
				return value;
			}
			System.out.println("Please enter a value between "+min+ " and "+max);
			
		}
	}
	
	public static String readString(String message) {
		while(true) {
			System.out.println(message+" ");
			String input = sc.nextLine().trim();
			if(!input.isEmpty()) {
				return input;
			}
			System.out.println("Input cannot be empty. Please try again");
		}
	}

}
