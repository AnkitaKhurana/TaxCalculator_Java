package com.tax.calculator;

import com.tax.classes.TypeAbstract;
import com.tax.constants.Constants;
import com.tax.models.Item;;

public class Raw extends TypeAbstract {

	public Double calculateTax(Item item) {
		item.setTax(Constants.BASIC_TAX_RATE * item.getCostPrice());
		return item.getTax();
	}

}
