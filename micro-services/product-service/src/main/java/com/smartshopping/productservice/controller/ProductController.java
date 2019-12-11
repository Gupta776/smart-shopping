package com.smartshopping.productservice.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopping.productservice.model.Products;
import com.smartshopping.productservice.security.AppUserDetailsService;
import com.smartshopping.productservice.services.ProductService;

@RestController
@RequestMapping("/smart-shopping/products")
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@GetMapping
	@Transactional
	public List<Products> getALLProducts() {
		LOGGER.info("Start");
		List<Products> productList = null;
		// Authentication authentication =
		// SecurityContextHolder.getContext().getAuthentication();
		// String user = authentication.getName();
		productList = productService.getAllProducts();
		return productList;
	}

	@GetMapping("/{id}")
	public Products getMenuItem(@PathVariable int id) {// throws SystemException {
		LOGGER.info("Start");
		LOGGER.info("end");
		System.out.println(productService.getProductItem(id));
		return productService.getProductItem(id);
	}

	@PutMapping
	public void updateProduct(@RequestBody Products productItem) {
		LOGGER.info("Start");
		productService.updateProduct(productItem);
		LOGGER.info("end");
	}

	@PostMapping
	public void addProduct(@RequestBody Products productItem) {
		LOGGER.info("Start");
		productService.addProduct(productItem);
		LOGGER.info("end");
	}
	
	@DeleteMapping("/{id}")
	public void deleyeProduct(@PathVariable("id") int id) {
		System.out.println(id);
		LOGGER.info("Start");
		productService.deleteProduct(id);
		LOGGER.info("end");
	}
	@GetMapping("/sort-by-popularity")
	public List<Products> sortByPopularity() {
		LOGGER.info("Start");
		return productService.getSortByPopularity();
	}

}
