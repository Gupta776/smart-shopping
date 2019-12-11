package com.smartshopping.productservice.services;

import java.util.List;

import com.smartshopping.productservice.model.Products;

public interface ProductService {
	public List<Products> getAllProducts();
	public Products getProductItem(int id);
	public void updateProduct(Products productItem);
	public void addProduct(Products productItem);
	public void deleteProduct(int id);
	public List<Products> getSortByPopularity();
}
