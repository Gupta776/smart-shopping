package com.smartshopping.productservice.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(com.smartshopping.productservice.controller.ProductController.class)
public class TestingForProductsController {
	@Autowired
	ProductController productController;
	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
		assertNotNull(productController);
	}
	
	@Test
    public void getProducts() throws Exception {
        ResultActions actions = mvc.perform(MockMvcRequestBuilders.get("/smart-shopping/products"));
        actions.andExpect(status().isOk());//if the status value is 200 then it is true
        actions.andExpect(jsonPath("$.id").exists());
//        actions.andExpect(jsonPath("$.code").value("IN"));
    }
}
