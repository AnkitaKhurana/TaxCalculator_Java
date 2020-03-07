package com.tax.calculator;

import com.tax.constants.Constants;
import com.tax.classes.*;
import com.tax.models.Item;

public class Manufactured extends TypeAbstract{

	public Double calculateTax(Item item) {
		double tax;
		double basicTax =Constants.BASIC_TAX_RATE * item.getCostPrice();
		tax = basicTax + 0.02 * (basicTax + item.getCostPrice());
		item.setTax(tax);
		return item.getTax();
	}

}
