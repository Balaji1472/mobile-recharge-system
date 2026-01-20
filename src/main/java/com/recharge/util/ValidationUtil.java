package com.recharge.util;

import java.util.regex.Pattern;

public final class ValidationUtil {
	
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
	
	private static final Pattern MOBILE_PATTERN = Pattern.compile("^[6-9][0-9]{9}$");
	
	private ValidationUtil() {
		
	}
	
	public static boolean isValidEmail(String email) {
		return email != null && EMAIL_PATTERN.matcher(email).matches();
	}
	
	public static boolean isValidMobile(String mobile) {
		return mobile != null && MOBILE_PATTERN.matcher(mobile).matches();
	}
	
	public static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
