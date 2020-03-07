package com.tax.utils;

import com.tax.models.Type;

public class ValidationUtil {
	public static boolean checkType(String value) {
		try {
			Type.valueOf(value);
			return false;

		} catch (Exception e) {
			System.out.println("Invalid type : (RAW|IMPORTED|MANUFACTURED)");
			return true;

		}
	}

	public static boolean checkPrice(String pr) {
		try {
			Double price = Convert.convertToDouble(pr);
			if (price > 0)
				return false;
			System.out.println("Invalid price - should be positive");
			return true;
		} catch (Exception e) {
			System.out.println("Invalid price - should be positive");
			return true;

		}
	}

	public static boolean checkQuantity(String q) {
		try {
			int quanity = Convert.convertToInteger(q);
			if (quanity > 0)
				return false;
			System.out.println("Invalid quantity - should be positive number");
			return true;
		} catch (Exception e) {
			System.out.println("Invalid quanity - should be positive number");
			return true;

		}
	}

	public static boolean checkName(String name) {
		try {
			if (name.matches("\\A\\p{ASCII}*\\z"))
				return false;
			System.out.println("Invalid Name - should be ascii");
			return true;
		} catch (Exception e) {
			System.out.println("Invalid name");
			return true;

		}
	}
}
