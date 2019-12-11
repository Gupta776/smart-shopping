package com.smartshopping.productservice.model;

public class ProductList {

	
	private int id;
	private int quantity;
	
	
	public ProductList() {
		super();
	}
	public ProductList(int productCode, int quantity) {
		super();
		this.id = productCode;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductList [id=" + id + ", quantity=" + quantity + "]";
	}
	
	
	
}
