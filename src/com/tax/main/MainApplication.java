package com.tax.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.tax.models.Item;
import com.tax.models.Type;
import com.tax.constants.*;
import com.tax.classes.TypeAbstract;
import com.tax.utils.*;

public class MainApplication {
	static Scanner scan = null;
	static String input = "";
	static String[] splitInput;
	static String name;
	static String type;

	public static void showResult(List<Item> items) {
		Iterator<Item> iterator = items.iterator();
		Item itemDetails1;
		TypeAbstract itemType1;
		int index = 0;
		while (iterator.hasNext()) {
			index++;
			System.out.println("Detail of item " + index);
			itemDetails1 = iterator.next();
			itemType1 = TypeAbstract.getType(itemDetails1.getType().toString());
			itemType1.printItems(itemDetails1);
		}
	}

	public static boolean validateInput() {
		boolean valid = true;
		for (int i = 0; i < splitInput.length; i++) {
			if (i == 0 && Constants.NAME.equals(splitInput[i])) {
				name = splitInput[++i];
				if (ValidationUtil.checkName(name)) {
					valid = false;
					break;
				}
			} else if (i == 0 && !Constants.NAME.equals(splitInput[i])) {
				System.out.println("Should start with name");
				break;
			} else if (i != 0) {
				if (Constants.TYPE.equals(splitInput[i])) {
					type = splitInput[++i].toUpperCase();
					if (ValidationUtil.checkType(type)) {
						valid = false;
						break;
					}

				} else if (Constants.QUANTITY.equals(splitInput[i])) {
					if (ValidationUtil.checkQuantity(splitInput[++i])) {
						valid = false;
						break;
					}
				} else if (Constants.PRICE.equals(splitInput[i])) {
					if (ValidationUtil.checkPrice(splitInput[++i])) {
						valid = false;
						break;
					}
				} else {
					valid = false;
					break;
				}
			}

		}
		return valid;
	}

	public static void main(String[] args) {
		double price = 0.0;
		int quantity = 0;
		boolean runLoop = true;
		boolean valid1 = true;
		List<Item> items = new ArrayList<>();
		try {
			while (runLoop) {
				System.out.println("Enter item details:");
				System.out.println("Format -name \"name\" -type  \"type\" [ -price \"price\" -quanity \"quantity\"]");
				type = "default";
				name = "default";
				price = 0.0;
				quantity = 0;
				valid1 = true;
				scan = new Scanner(System.in);
				input = scan.nextLine();
				splitInput = input.split("\\s+");
				if (splitInput.length < 4) {
					System.out.println("Missing fields");
				} else if (splitInput.length > 8) {
					System.out.println("Invalid Input");
				}
				valid1 = validateInput();

				if (valid1 && !type.equals("default")) {
					Item itemDetails = new Item(name, price, quantity, Type.valueOf(type));
					TypeAbstract itemType = TypeAbstract.getType(type);
					itemDetails.setTax(itemType.calculateTax(itemDetails));
					itemDetails.setSellingPrice(itemType.calculateSellingPrice(itemDetails));
					items.add(itemDetails);
				} else {
					System.out.println("Invalid input \n Name and type are compulsary \n use format: ");
					System.out.println("-name \"name\" -type  \"type\" [ --price \"price\" --quanity \"quantity\"]");
				}
				System.out.println("Do you want to enter details of any other items? y/n");
				char ch = scan.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					runLoop = true;
				} else {
					showResult(items);
					runLoop = false;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (scan != null)
				scan.close();
			System.out.println("Program Terminated");
		}

	}

}
