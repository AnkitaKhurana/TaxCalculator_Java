package com.tax.classes;

import com.tax.calculator.Imported;
import com.tax.calculator.Manufactured;
import com.tax.calculator.Raw;
import com.tax.models.Item;
import com.tax.models.Type;

public abstract class TypeAbstract {

	public Double calculateTax(Item item) {
		return null;
	};

	public Double calculateSellingPrice(Item item) {
		item.setSellingPrice((item.getTax() + item.getCostPrice()) * item.getQuantity());
		return item.getSellingPrice();
	};

	public void printItems(Item item) {
		System.out.println("Name " + item.getName());
		System.out.println("Price " + item.getCostPrice());
		System.out.println("Tax " + item.getTax());
		System.out.println("Selling price " + item.getSellingPrice());
	};

	public static TypeAbstract getType(String type) {

		switch (Type.valueOf(type)) {
		case RAW:
			return new Raw();
		case MANUFACTURED:
			return new Manufactured();
		case IMPORTED:
			return new Imported();
		default:
			break;
		}
		return null;
	}

}
