package com.smartshopping.productservice.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshopping.productservice.model.Products;
import com.smartshopping.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	@Transactional
	public List<Products> getAllProducts(){
		LOGGER.info("Start");
		LOGGER.info("End");
		return productRepository.findAll();	
	}

	@Override
	@Transactional
	public Products getProductItem(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		LOGGER.info("End");
		System.out.println(id);
		System.out.println(productRepository.findById(id));
		return productRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void updateProduct(Products productItem) {
		System.out.println(productRepository.save(productItem));
		productRepository.save(productItem);
	}

	@Override
	public void addProduct(Products productItem) {
		System.out.println(productRepository.save(productItem));
		productRepository.save(productItem);
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Products> getSortByPopularity() {
		List<Products> productArray = productRepository.getProductArray1();
		productArray.addAll(productRepository.getProductArray2());
		System.out.println(productArray);
		return productArray;
	}
}
