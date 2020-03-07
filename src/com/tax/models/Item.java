package com.tax.models;

public class Item {

	private String name;

	private Type type;

	private Double costPrice;

	private Integer quantity;

	private Double tax;

	private Double sellingPrice;

	public Item(String name, Double cost, int quantity, Type type) {
		this.name = name;
		this.setCostPrice(cost);
		this.setQuantity(quantity);
		this.setType(type);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Double getSellingPrice() {
		return this.sellingPrice;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

}
