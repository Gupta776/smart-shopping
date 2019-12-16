package com.smartshopping.productservice.controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartshopping.productservice.model.Users;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TestingForUserController {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	UserController userController;
	
	@Autowired
	private MockMvc mvc;
//	
//	@Test
//	public void allUsers() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/smart-shopping/users/all-users")).andExpect(status().isOk());
//	}
	Users createUser(){
		Users user = new Users(2, "customer", "customer", 30, "Male", 1111111112, "c1", "$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS", "U", "A", "What is your favorite book ", "Robotics", "What is your lucky item", "Cake", "What is your favorite movie", "kingkong",0);
	return user;
	}
	@Test
	public void getUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/smart-shopping/users/user1/4")).andExpect(status().isOk());
	}
	@Test
	public void getUserByContactNumber() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/smart-shopping/users/contact-number/1111111112")).andExpect(status().isOk());
	}
	@Test
	public void updatePassword() throws Exception {
		mvc.perform(MockMvcRequestBuilders.put("/smart-shopping/users/new-password").content(asJsonString(createUser()))
				.contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
		}
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
