package com.tax.calculator;

import com.tax.classes.TypeAbstract;
import com.tax.constants.Constants;
import com.tax.models.Item;

public class Imported extends TypeAbstract {

	public Double calculateTax(Item item) {
		double finalTax;
		double importDuty = Constants.IMPORT_DUTY_TAX_RATE * item.getCostPrice();

		double surcharge = 0;
		double amtIncludingImportDuty = importDuty + item.getCostPrice();
		if (amtIncludingImportDuty <= 100) {
			surcharge = Constants.MIN_SURCHARGE;
		} else if (amtIncludingImportDuty > 100 && amtIncludingImportDuty <= 200) {
			surcharge = Constants.MEDIUM_SURCHARGE;
		} else
			surcharge = 0.05 * amtIncludingImportDuty;
		finalTax = importDuty + surcharge;
		item.setTax(finalTax);
		return item.getTax();
	}
}
