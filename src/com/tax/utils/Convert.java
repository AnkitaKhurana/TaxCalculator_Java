package com.tax.utils;

import com.tax.exceptions.InvalidInputException;

public class Convert {

	public static int convertToInteger(String value) throws InvalidInputException {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException ex) {
			throw new InvalidInputException(ex.getMessage());
		}
	}

	public static double convertToDouble(String value) throws InvalidInputException {
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException ex) {
			throw new InvalidInputException(ex.getMessage());
		}

	}
}
